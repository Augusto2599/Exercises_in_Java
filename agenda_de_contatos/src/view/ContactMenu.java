package view;

import model.enums.MenuOption;
import util.InputReader;

public class ContactMenu {

    private final InputReader inputReader;

    public ContactMenu() {
        this.inputReader = new InputReader();
    }

    // Exibe o menu e retorna a opção escolhida pelo usuário.
    public MenuOption showMenu() {
        System.out.println("\n=== AGENDA DE CONTATOS ===");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Listar contatos");
        System.out.println("3 - Editar contato");
        System.out.println("4 - Remover contato");
        System.out.println("5 - Buscar contato por nome");
        System.out.println("6 - Sair");
        int choice = inputReader.readInt("Escolha uma opção: ", 1, 6);

        return switch (choice) {
            case 1 -> MenuOption.ADICIONAR;
            case 2 -> MenuOption.LISTAR;
            case 3 -> MenuOption.EDITAR;
            case 4 -> MenuOption.REMOVER;
            case 5 -> MenuOption.BUSCAR_POR_NOME;
            case 6 -> MenuOption.ENCERRAR;
            default -> {
                System.out.println("Opção inválida.");
                yield MenuOption.ENCERRAR;
            }
        };
    }

    // Solicita os dados para criar ou editar um contato.
    public String[] requestContactData() {
        String name = inputReader.readString("Nome: ");
        String phone = inputReader.readString("Telefone (formato (XX) XXXXX-XXXX): ");
        String email = inputReader.readString("Email (opcional, deixe vazio se não tiver): ");
        String type = inputReader.readString("Tipo de contato (PESSOAL, PROFISSIONAL, FAMILIAR, OUTRO): ").toUpperCase();
        return new String[]{name, phone, email, type};
    }

    // Solicita o ID do contato para operações de edição ou remoção.
    public int requestContactId() {
        return inputReader.readInt("Informe o ID do contato: ");
    }

    // Exibe uma mensagem simples para o usuário.
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Exibe uma lista de contatos formatada.
    public void showContacts(String contacts) {
        System.out.println(contacts);
    }

    public String readString(String prompt) {
        return inputReader.readString(prompt);
    }

}
