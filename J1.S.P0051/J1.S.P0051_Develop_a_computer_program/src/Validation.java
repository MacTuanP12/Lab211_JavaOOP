
public class Validation {


    public Double checkIn(String inputVal) {
        if (inputVal == null || inputVal.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(inputVal.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public Operator checkOperator(String operator) {
        if (operator == null) {
            return null;
        }
        try {
            String op = operator.trim();
            for (Operator o : Operator.values()) {
                if (o.getSymbol().equals(op)) {
                    return o;
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }


    public boolean isPositive(double value) {
        return value > 0;
    }
}

