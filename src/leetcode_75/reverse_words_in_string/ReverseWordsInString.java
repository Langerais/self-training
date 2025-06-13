package leetcode_75.reverse_words_in_string;

import java.util.ArrayList;

public class ReverseWordsInString {


    public static void main(String[] args) {

        String s1 = "Hello World";
        String s2 = "  Hello World   here ";


        System.out.println(reverseWordsInPlace(s1));
        System.out.println(reverseWordsInPlace(s2));

    }


    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        StringBuilder out = new StringBuilder();

        int left = 0;
        int right = words.length-1;
        String temp;

        while (left < right){
            temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        for(String w : words){
            out.append(w).append(" ");
        }

        return out.toString();
    }

    public static String reverseWordsInPlace(String s){     //TODO: Make this.

        ArrayList<Character> mutable = new ArrayList<>();

        for (char c : s.toCharArray()) mutable.add(c);

        int left = 0;
        int right = mutable.size()-1;
        int offset = 0;
        char temp;

        while (mutable.get(left) == ' '){
            offset++;
            left++;
        }

        while (left<right){

            while (left < right && mutable.get(left) == ' ' && mutable.get(left+1) == ' ') {
                left++;
                offset++;
            }
            while (left < right && mutable.get(right) == ' ' && mutable.get(right-1) == ' ') {
                right--;
                offset++;
            }

            temp = mutable.get(right);
            mutable.set(right, mutable.get(left));
            mutable.set(left - offset, temp);

            left++;
            right--;
        }

        return mutable.toString();

    }




}
