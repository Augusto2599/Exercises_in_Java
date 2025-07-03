package service;

import model.entities.Contact;
import repository.ContactRepository;

import java.util.List;
import java.util.regex.Pattern;

public class ContactService {

    private final ContactRepository repository;

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\(\\d{2}\\) \\d{4,5}-\\d{4}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    private boolean validarContato(Contact contato) {
        if (contato.getFullName() == null || contato.getFullName().trim().isEmpty()) {
            System.out.println("Nome do contato não pode ser vazio.");
            return false;
        }

        if (contato.getPhoneNumber() == null || !PHONE_PATTERN.matcher(contato.getPhoneNumber()).matches()) {
            System.out.println("Telefone inválido. Formato esperado: (XX) XXXXX-XXXX");
            return false;
        }

        if (contato.getEmail() != null && !contato.getEmail().trim().isEmpty()) {
            if (!EMAIL_PATTERN.matcher(contato.getEmail()).matches()) {
                System.out.println("Email inválido.");
                return false;
            }
        }

        if (contato.getContactType() == null) {
            System.out.println("Tipo de contato deve ser informado.");
            return false;
        }

        return true;
    }


    public Contact adicionarContato(Contact contato) {
        if (validarContato(contato)) {
            return repository.adicionarContato(contato);
        }
        return null;
    }

    public boolean removerContato(int id) {
        return repository.removerContato(id);
    }

    public Contact buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public List<Contact> buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public List<Contact> listarContatos() {
        return repository.listarTodos();
    }

    public boolean atualizarContato(Contact contato) {
        if (validarContato(contato)) {
            return repository.atualizarContato(contato);
        }
        return false;
    }
}
