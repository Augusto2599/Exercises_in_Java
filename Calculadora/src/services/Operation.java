package services;

import enums.OperationType;
import services.operations.*;

public class Operation {

    // Método de fábrica para executar uma operação com base no tipo
    public static double execute(OperationType type, double a, double b) {

        // Crie uma instância da estratégia apropriada com base no tipo de operação
        OperationStrategy strategy;

        // Use uma instrução switch para determinar o tipo de operação
        switch (type) {
            case SUM:
                strategy = new Sum();
                break;
            case SUBTRACT:
                strategy = new Subtract();
                break;
            case MULTIPLY:
                strategy = new Multiply();
                break;
            case DIVIDE:
                strategy = new Divide();
                break;
            case POTENTIATION:
                strategy = new Potentiation();
                break;
            case PERCENT:
                strategy = new Percent();
                break;
            default:
                throw new IllegalArgumentException("Operação invalida. " + type);
        }
        // Execute a operação usando a estratégia selecionada
        return strategy.execute(a, b);
    }
}
