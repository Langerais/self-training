package leetcode_75.merge_strings_alt;

public class MergeAlternately {


    public String mergeAlternately(String word1, String word2) {

        StringBuilder out = new StringBuilder();
        boolean firstLonger = word1.length()>word2.length();
        int finalLen = firstLonger ? word2.length() : word1.length();

        for(int i = 0; i < finalLen; i++){
            out.append(word1.charAt(i));
            out.append(word2.charAt(i));
        }

        String end = firstLonger ? word1.substring(finalLen) : word2.substring(finalLen);

       out.append(end);

        return out.toString();

    }


}
