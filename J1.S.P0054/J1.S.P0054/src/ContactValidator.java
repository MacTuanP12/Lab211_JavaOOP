import java.util.regex.Pattern;


public class ContactValidator {

    // Phone number validation patterns
    private static final String[] PHONE_PATTERNS = {
        "^\\d{10}$",                                    // 1234567890
        "^\\d{3}-\\d{3}-\\d{4}$",                      // 123-456-7890
        "^\\d{3}-\\d{3}-\\d{4}\\s+x\\d+$",            // 123-456-7890 x1234
        "^\\d{3}-\\d{3}-\\d{4}\\s+ext\\d+$",          // 123-456-7890 ext1234
        "^\\(\\d{3}\\)-\\d{3}-\\d{4}$",               // (123)-456-7890
        "^\\d{3}\\.\\d{3}\\.\\d{4}$",                 // 123.456.7890
        "^\\d{3}\\s+\\d{3}\\s+\\d{4}$"                // 123 456 7890
    };


    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return false;
        }

        for (String pattern : PHONE_PATTERNS) {
            if (Pattern.matches(pattern, phone.trim())) {
                return true;
            }
        }
        return false;
    }


    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }


    public static boolean isValidId(int id) {
        return id > 0;
    }
}

