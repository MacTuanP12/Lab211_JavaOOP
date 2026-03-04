
public class Calculator {


    public double calculate(double a, Operator operator, double b) {
        if (operator == null) {
            throw new IllegalArgumentException("Operator cannot be null");
        }

        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

