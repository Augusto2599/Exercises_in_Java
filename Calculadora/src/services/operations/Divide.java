package services.operations;

public class Divide implements OperationStrategy {

    // Essa anotação indica que este método sobrescreve um método da interface OperationStrategy
    @Override
    public double execute(double a, double b) {
        if (a == 0 || b == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida.");
        } else {
                return a / b;
        }
    } // Método que executa a operação de divisão entre dois números e retorna o resultado
}
