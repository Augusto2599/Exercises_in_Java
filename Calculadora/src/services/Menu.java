package services;

import enums.MenuOptions;
import enums.OperationType;

import java.util.Scanner;

public class Menu {

    // Method to display the main menu and return the user's choice
    private final Scanner scan = new Scanner(System.in);

    // Method to show the main menu and return the selected option
    public MenuOptions showMainMenu() {
        System.out.println("===== CALCULADORA =====");
        System.out.println("\n1. Realizar Operação");
        System.out.println("\n2. Resetar Calculadora");
        System.out.println("\n3. Sair");
        System.out.println("\nEscolha uma opção: ");

        // Read the user's choice
        int option = scan.nextInt();

        // Validate the input and return the corresponding MenuOptions
        switch (option) {
            case 1:
                return MenuOptions.PERFORM_OPERATION;
            case 2:
                return MenuOptions.RESET;
            case 3:
                return MenuOptions.EXIT;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return showMainMenu(); // Recursive call to show the menu again
        }
    }

    // Method to ask the user for the type of operation they want to perform
    public OperationType askOperationType() {
        System.out.println("------ Escolha uma Opção ------");
        System.out.println("\n1. Soma (+)");
        System.out.println("\n2. Subtração (-)");
        System.out.println("\n3. Multiplicação (*)");
        System.out.println("\n4. Divisão (/)");
        System.out.println("\n5. Potenciação (^)");
        System.out.println("\n6. Porcentagem (%)");
        System.out.println("\nDigite o número da operação que deseja realizar:");

        // Method to ask the user for the type of operation they want to perform
        int op = scan.nextInt();

        // Validate the input and return the corresponding OperationType
        switch (op) {
            case 1:
                return OperationType.SUM;
            case 2:
                return OperationType.SUBTRACT;
            case 3:
                return OperationType.MULTIPLY;
            case 4:
                return OperationType.DIVIDE;
            case 5:
                return OperationType.POTENTIATION;
            case 6:
                return OperationType.PERCENT;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                return askOperationType(); // Recursive call to ask again
        }
    }

    // Method to ask the user for a value with a label
    public double askValue(String label) {
        System.out.println("Digite o valor de " + label + ": ");
        return scan.nextDouble();
    }
}
