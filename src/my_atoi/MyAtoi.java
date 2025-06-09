package my_atoi;

public class MyAtoi {

    public static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public static int myAtoi(String s) {

        if(s.length() == 0) return 0;

        int sign = 1;
        int out = 0;
        boolean numStarted = false;

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++){

            if(!numStarted){
                if (chars[i] == ' ') continue;
                if(chars[i] == '-' || chars[i] == '+'){
                    sign = chars[i] == '-' ? -1 : chars[i] == '+' ? 1 : sign;
                    numStarted = true;
                    continue;
                }
                if(isNum(chars[i])) numStarted = true;
            }

            if(chars[i] != '-' && chars[i] != '+' && !isNum(chars[i])) break;

            if(numStarted) {
                if(isNum(chars[i])) {
                    if (out > Integer.MAX_VALUE / 10 || (out == Integer.MAX_VALUE / 10 && (chars[i] - '0') > 7)) {
                        return Integer.MAX_VALUE;
                    }
                    if (out < Integer.MIN_VALUE / 10 || (out == Integer.MIN_VALUE / 10 && (chars[i] - '0') > 8)) {
                        return Integer.MIN_VALUE;
                    }
                    out = out * 10 + ((chars[i] - '0') * sign);

                }
                else break;
            }
        }

        return out;
    }

}
