package myutil;

public final class InputFilter {
        /**
        * Filter the specified message string for characters that are sensitive
        * in HTML.  This avoids potential attacks caused by including JavaScript
        * codes in the request URL that is often reported in error messages.
        */
    public static String htmlFilter(String message) {
        if (message == null) return null;
        int len = message.length();
        StringBuilder result = new StringBuilder(len + 20);
        char aChar;

        for (int i = 0; i < len; ++i) {
        aChar = message.charAt(i);
        switch (aChar) {
        case '<':
            result.append("&lt;");
            break;
        case '>':
            result.append("&gt;");
            break;
        case '&':
            result.append("&amp;");
            break;
        case '"':
            result.append("&quot;");
            break;
        default:
            result.append(aChar);
        }
        }
        return (result.toString());
    }

    /**
     *  Given a phone number string, return true if it is an 8-digit number
    */
    public static boolean isValidPhone(String phoneNumber) {
        if (phoneNumber.length() != 8) {
        return false;
        }
        for (int i = 0; i < phoneNumber.length(); ++i) {
        char c = phoneNumber.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
        }
        return true;
    }

    /**
     * Given a string, return a positive integer if the string can be parsed into
    * a positive integer. Return 0 for non-positive integer or parsing error.
    */
    public static int parsePositiveInt(String str) {
        if (str == null || (str = str.trim()).length() == 0) {
        return 0;
        }

        int result;
        try {
        result = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
        return 0;
        }
        return (result > 0) ? result : 0;
    }
}
