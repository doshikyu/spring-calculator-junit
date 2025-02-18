package pro.sky.calculatorjunit.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final String PLUS = " + ";
    private final String MINUS = " - ";
    private final String MULTIPLY = " * ";
    private final String DIVIDE = " / ";

    @Override
    public String calculatePlus(Double num1, Double num2) {
        validateInputs(num1, num2, false);
        return calculate(num1, num2, PLUS);
    }

    @Override
    public String calculateMinus(Double num1, Double num2) {
        validateInputs(num1, num2, false);
        return calculate(num1, num2, MINUS);
    }

    @Override
    public String calculateMultiply(Double num1, Double num2) {
        validateInputs(num1, num2, false);
        return calculate(num1, num2, MULTIPLY);
    }

    @Override
    public String calculateDivide(Double num1, Double num2) {
        validateInputs(num1, num2, true);
        return calculate(num1, num2, DIVIDE);
    }

    private void validateInputs(Double num1, Double num2, boolean isDivide) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Cannot make calculations with null.");
        }
        if (isDivide && num2 == 0) {
            throw new ArithmeticException("Cannot divide by 0.");
        }
    }

    private String calculate(Double num1, Double num2, String operation) {
        Double result = 0.0;
        switch (operation) {
            case PLUS:
                return String.format("%.2f + %.2f = %.2f", num1, num2, num1 + num2);
            case MINUS:
                return String.format("%.2f - %.2f = %.2f", num1, num2, num1 - num2);
            case MULTIPLY:
                return String.format("%.2f * %.2f = %.2f", num1, num2, num1 * num2);
            case DIVIDE:
                return String.format("%.2f / %.2f = %.2f", num1, num2, num1 / num2);
            default:
                throw new UnsupportedOperationException("Operation not supported.");
        }
    }
}
