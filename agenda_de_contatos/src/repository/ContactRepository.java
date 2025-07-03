package repository;

import model.entities.Contact;

import java.util.*;

public class ContactRepository {

    // Armazena os contatos com chave sendo o ID
    private final Map<Integer, Contact> contacts = new HashMap<>();

    // Gerador de IDs automáticos
    private int currentId = 1;

    // Adiciona um novo contato e atribui um ID automaticamente.
    public Contact adicionarContato(Contact contato) {
        contato.setId(currentId++);
        contacts.put(contato.getId(), contato);
        return contato;
    }

    // Remove um contato com base no ID.
    public boolean removerContato(int id) {
        return contacts.remove(id) != null;
    }

    // Busca um contato pelo ID.
    public Contact buscarPorId(int id) {
        return contacts.get(id);
    }

    // Busca todos os contatos cujo nome contenha o texto informado (case insensitive).
    public List<Contact> buscarPorNome(String nome) {
        List<Contact> resultado = new ArrayList<>();
        for (Contact contact : contacts.values()) {
            if (contact.getFullName().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(contact);
            }
        }
        return resultado;
    }

    // Retorna a lista completa de contatos.
    public List<Contact> listarTodos() {
        return new ArrayList<>(contacts.values());
    }

    // Atualiza um contato existente com base no ID.
    public boolean atualizarContato(Contact contatoAtualizado) {
        int id = contatoAtualizado.getId();
        if (contacts.containsKey(id)) {
            contacts.put(id, contatoAtualizado);
            return true;
        }
        return false;
    }
}