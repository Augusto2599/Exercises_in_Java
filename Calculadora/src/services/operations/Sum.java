package services.operations;

public class Sum implements OperationStrategy{

    // Essa anotação indica que este método sobrescreve um método da interface OperationStrategy
    @Override
    public double execute(double a, double b) {
        return a + b;
    } // Método que executa a operação de soma entre dois números e retorna o resultado

}
