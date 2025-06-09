package is_number;

public class IsNumber {

    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        char[] chars = s.trim().toCharArray();
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                digitSeen = true;
            } else if (c == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !digitSeen) return false;
                eSeen = true;
                digitSeen = false; // reset for checking digits after e
            } else if (c == '+' || c == '-') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') return false;
            } else {
                return false;
            }
        }
        return digitSeen;
    }

}

