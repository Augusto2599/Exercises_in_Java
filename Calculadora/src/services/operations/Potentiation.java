package services.operations;

public class Potentiation implements OperationStrategy {

    // Essa anotação indica que este método sobrescreve um método da interface OperationStrategy
    @Override
    public double execute(double a, double b) {
        return Math.pow(a, b);
    } // Método que executa a operação de potenciação entre dois números e retorna o resultado

}
