package controler;

import model.entities.Contact;
import model.enums.ContactType;
import model.enums.MenuOption;
import service.ContactService;
import view.ContactMenu;

import java.util.List;

public class ContactController {

    private final ContactService contactService;
    private final ContactMenu contactMenu;

    public ContactController(ContactService contactService, ContactMenu contactMenu) {
        this.contactService = contactService;
        this.contactMenu = contactMenu;
    }

    public void iniciar() {
        boolean executando = true;
        while (executando) {
            MenuOption opcao = contactMenu.showMenu();

            switch (opcao) {
                case ADICIONAR -> adicionarContato();
                case LISTAR -> listarContatos();
                case EDITAR -> editarContato();
                case REMOVER -> removerContato();
                case BUSCAR_POR_NOME -> buscarPorNome();
                case ENCERRAR -> {
                    contactMenu.showMessage("Encerrando o programa...");
                    executando = false;
                }
            }
        }
    }

    private void adicionarContato() {
        String[] dados = contactMenu.requestContactData();
        try {
            Contact contato = new Contact();
            contato.setFullName(dados[0]);
            contato.setPhoneNumber(dados[1]);
            contato.setEmail(dados[2].isEmpty() ? null : dados[2]);
            contato.setContactType(ContactType.valueOf(dados[3]));

            Contact adicionado = contactService.adicionarContato(contato);
            if (adicionado != null) {
                contactMenu.showMessage("Contato adicionado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            contactMenu.showMessage("Tipo de contato inválido.");
        }
    }

    private void listarContatos() {
        List<Contact> contatos = contactService.listarContatos();
        if (contatos.isEmpty()) {
            contactMenu.showMessage("Nenhum contato encontrado.");
        } else {
            StringBuilder sb = new StringBuilder("Lista de contatos:\n");
            for (Contact c : contatos) {
                sb.append(formatarContato(c)).append("\n");
            }
            contactMenu.showContacts(sb.toString());
        }
    }

    private void editarContato() {
        int id = contactMenu.requestContactId();
        Contact existente = contactService.buscarPorId(id);
        if (existente == null) {
            contactMenu.showMessage("Contato não encontrado.");
            return;
        }

        String[] dados = contactMenu.requestContactData();
        try {
            existente.setFullName(dados[0]);
            existente.setPhoneNumber(dados[1]);
            existente.setEmail(dados[2].isEmpty() ? null : dados[2]);
            existente.setContactType(ContactType.valueOf(dados[3]));

            boolean atualizado = contactService.atualizarContato(existente);
            contactMenu.showMessage(atualizado ? "Contato atualizado com sucesso!" : "Falha ao atualizar o contato.");
        } catch (IllegalArgumentException e) {
            contactMenu.showMessage("Tipo de contato inválido.");
        }
    }

    private void removerContato() {
        int id = contactMenu.requestContactId();
        boolean removido = contactService.removerContato(id);
        contactMenu.showMessage(removido ? "Contato removido com sucesso!" : "Contato não encontrado.");
    }

    private void buscarPorNome() {
        String nome = contactMenu.readString("Digite o nome para busca: ");
        List<Contact> encontrados = contactService.buscarPorNome(nome);
        if (encontrados.isEmpty()) {
            contactMenu.showMessage("Nenhum contato encontrado com esse nome.");
        } else {
            StringBuilder sb = new StringBuilder("Contatos encontrados:\n");
            for (Contact c : encontrados) {
                sb.append(formatarContato(c)).append("\n");
            }
            contactMenu.showContacts(sb.toString());
        }
    }

    private String formatarContato(Contact c) {
        return String.format("ID: %d | Nome: %s | Telefone: %s | Email: %s | Tipo: %s",
                c.getId(), c.getFullName(), c.getPhoneNumber(),
                (c.getEmail() != null ? c.getEmail() : "N/A"),
                c.getContactType());
    }
}
