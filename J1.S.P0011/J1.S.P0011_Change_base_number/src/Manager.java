
public class Manager {


    public static String convertBase(String input, int fromBase, int toBase) {
        // Bước 1: Chuyển đổi từ hệ cơ số nguồn sang thập phân
        // Sử dụng Long.parseLong() với tham số radix để chuyển đổi
        long decimalValue = convertToDecimal(input, fromBase);

        // Bước 2: Chuyển đổi từ thập phân sang hệ cơ số đích
        String result = convertFromDecimal(decimalValue, toBase);

        return result;
    }

    private static long convertToDecimal(String input, int fromBase) {
        if (fromBase == 10) {
            return Long.parseLong(input);
        } else if (fromBase == 2) {
            // Chuyển từ binary sang decimal
            // Long.parseLong với radix 2
            return Long.parseLong(input, 2);
        } else if (fromBase == 16) {
            // Chuyển từ hexadecimal sang decimal
            // Long.parseLong với radix 16
            return Long.parseLong(input, 16);
        } else {
            throw new IllegalArgumentException("Unsupported base: " + fromBase);
        }
    }


    private static String convertFromDecimal(long decimalValue, int toBase) {
        if (toBase == 10) {
            return String.valueOf(decimalValue);
        } else if (toBase == 2) {
            // Chuyển từ decimal sang binary
            // Sử dụng thuật toán chia liên tiếp cho 2
            return Long.toBinaryString(decimalValue);
        } else if (toBase == 16) {
            // Chuyển từ decimal sang hexadecimal
            // Sử dụng thuật toán chia liên tiếp cho 16
            return Long.toHexString(decimalValue).toUpperCase();
        } else {
            throw new IllegalArgumentException("Unsupported base: " + toBase);
        }
    }


    public static String getBaseName(int base) {
        switch (base) {
            case 2:
                return "Binary";
            case 10:
                return "Decimal";
            case 16:
                return "Hexadecimal";
            default:
                return "Unknown";
        }
    }
}

