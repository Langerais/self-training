package reverse_integer;

public class ReverseInteger {

    public int reverse(int x) {

        int out = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (x != 0){

            int pop = x % 10;
            x /= 10;

            if(out > max / 10 || (out == max / 10 && pop > max % 10)) return 0;
            if(out < min / 10 || (out == min / 10 && pop < min % 10)) return 0;

            out = out * 10 + pop;

        }
        return out;
    }



}
