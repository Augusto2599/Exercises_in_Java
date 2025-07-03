package util;

import java.util.Scanner;

public class InputReader {

    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    // Lê uma String não vazia do usuário, mostrando um prompt.
    public String readString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Entrada não pode ser vazia. Tente novamente.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Lê um número inteiro do usuário, mostrando um prompt.
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    // Lê um inteiro dentro de um intervalo [min, max], mostrando um prompt.
    public int readInt(String prompt, int min, int max) {
        int num;
        do {
            num = readInt(prompt);
            if (num < min || num > max) {
                System.out.printf("Número deve estar entre %d e %d. Tente novamente.%n", min, max);
            }
        } while (num < min || num > max);
        return num;
    }
}
