package services.operations;

public class Percent implements OperationStrategy {

    // Essa anotação indica que este método sobrescreve um método da interface OperationStrategy
    @Override
    public double execute(double a, double b) {
        return (a * b) / 100.0;
    } // Método que executa a operação de porcentagem entre dois números e retorna o resultado
}
