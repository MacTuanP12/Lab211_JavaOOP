/**
 * Enum representing mathematical operators (+, -, *, /, ^, =)
 */
public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    EXPONENT("^"),
    EQUAL("=");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

