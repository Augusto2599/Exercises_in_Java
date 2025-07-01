package services.operations;

public class Multiply implements OperationStrategy{

    // Essa anotação indica que este método sobrescreve um método da interface OperationStrategy
    @Override
    public double execute(double a, double b) {
        return a * b;
    } // Método que executa a operação de multiplicação entre dois números e retorna o resultado
}
