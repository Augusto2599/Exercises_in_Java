package entities;

public class Calculator {

    // Essa classe representa uma calculadora simples que pode realizar operações matemáticas básicas.
    private double currentValue;

    // O valor atual da calculadora, que é atualizado após cada operação.
    public Calculator() {
        this.currentValue = 0.0;
    }

    // Construtor que inicializa o valor atual da calculadora como zero.
    public double getCurrentValue() {
        return currentValue;
    }

    // Método para obter o valor atual da calculadora.
    public void setCurrentValue(double Value) {
        this.currentValue = Value;
    }

    // Método para definir o valor atual da calculadora.
    public void reset() {
        this.currentValue = 0.0;
    }
}
