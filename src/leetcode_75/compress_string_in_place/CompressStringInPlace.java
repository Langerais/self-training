package leetcode_75.compress_string_in_place;

import java.util.Arrays;

public class CompressStringInPlace {

    public int compress(char[] chars) {
        int len = chars.length + 1;
        int count = 0;
        int putIndex = 0;

        if(len < 2) return len;

        char check = chars[0];

        for(int i = 0; i < chars.length; i++){

            if(chars[i] == check){
                count++;
                len--;
            }
            if(chars[i] != check || i == chars.length - 1){
                putIndex++;
                if(count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[putIndex] = c;
                        putIndex++;
                        len++;
                    }
                }
                count = 1;
            }

            check = chars[i];
        }
        System.out.println(Arrays.toString(chars));
        System.out.println(putIndex);
        return len;
    }




}
