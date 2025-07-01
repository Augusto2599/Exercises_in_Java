import entities.Calculator;
import enums.MenuOptions;
import enums.OperationType;
import services.Menu;
import services.Operation;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator(); // Instancia a calculadora
        Menu menu = new Menu(); // Instancia o menu

        boolean running = true; // Variável para controlar o loop do menu

        // Loop principal do menu
        while (running) {
            MenuOptions option = menu.showMainMenu(); // Exibe o menu e obtém a opção escolhida pelo usuário

            // Verifica a opção escolhida e executa a ação correspondente
            switch (option) {
                case PERFORM_OPERATION:
                    OperationType type = menu.askOperationType(); // Solicita o tipo de operação ao usuário

                    double a = menu.askValue("A"); // Solicita o primeiro valor
                    double b = menu.askValue("B"); // Solicita o segundo valor

                    try {
                        double result = Operation.execute(type, a, b); // Executa a operação com os valores fornecidos

                        calculator.setCurrentValue(result); // Atualiza o valor atual da calculadora

                        System.out.println("Resultado: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case RESET:
                    calculator.reset(); // Reinicia a calculadora
                    System.out.println("Calculadora reiniciada.");
                    break;
                case EXIT:
                    System.out.println("Encerrando o programa...");
                    running = false; // Encerra o loop do menu
                    break;
            }
        }

    }
}