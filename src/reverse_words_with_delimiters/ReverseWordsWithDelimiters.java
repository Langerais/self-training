package reverse_words_with_delimiters;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseWordsWithDelimiters {
    public static void main(String[] args) {

        System.out.println(reverseWords("hello/world:here", new char[]{'/', ':'}));
        // Expected: "here/world:hello"

        System.out.println(reverseWords("hello/world:here/", new char[]{'/', ':'}));
        // Expected: "here/world:hello/"

        System.out.println(reverseWords("hello//world:here", new char[]{'/', ':'}));
        // Expected: "here//world:hello"

        System.out.println(reverseWords("a:b:c", new char[]{':'}));
        // Expected: "c:b:a"

        System.out.println(reverseWords("/a:b:c", new char[]{':', '/'}));
        // Expected: "/c:b:a"

        System.out.println(reverseWords("word1,word2.word3", new char[]{',', '.'}));
        // Expected: "word3,word2.word1"

        System.out.println(reverseWords("///", new char[]{'/'}));
        // Expected: "///"

        System.out.println(reverseWords("", new char[]{':'}));
        // Expected: ""

        System.out.println(reverseWords("abc", new char[]{':'}));
        // Expected: "abc"

    }


    static String reverseWords(String input, char[] delimiters) {

        ArrayList<String> tokens = new ArrayList<>();

        HashSet<Character> delimSet = new HashSet<>();

        for(char c : delimiters) delimSet.add(c);

        StringBuilder curr = new StringBuilder();

        for(char c : input.toCharArray()){

            if(delimSet.contains(c)){

                if(!curr.isEmpty()){ tokens.add(curr.toString()); }

                curr.setLength(0);
                tokens.add(String.valueOf(c));

            } else {
                curr.append(c);
            }

        }

        if(!curr.isEmpty()) tokens.add(curr.toString());

        int start = 0;
        int end = tokens.size() - 1;

        while(start < end){

            if(delimSet.contains(tokens.get(start).charAt(0))){
                start++;
                continue;
            }
            if(delimSet.contains(tokens.get(end).charAt(0))){
                end--;
                continue;
            }

            String temp = tokens.get(start);
            tokens.set(start, tokens.get(end));
            tokens.set(end, temp);
            start++;
            end--;

        }
        return String.join("", tokens);
    }

    @Test
    void testBasicCases() {
        assertEquals("here/world:hello", reverseWords("hello/world:here", new char[]{'/', ':'}));
        assertEquals("here/world:hello/", reverseWords("hello/world:here/", new char[]{'/', ':'}));
        assertEquals("here//world:hello", reverseWords("hello//world:here", new char[]{'/', ':'}));
        assertEquals("c:b:a", reverseWords("a:b:c", new char[]{':'}));
        assertEquals("/c:b:a", reverseWords("/a:b:c", new char[]{':', '/'}));
        assertEquals("word3,word2.word1", reverseWords("word1,word2.word3", new char[]{',', '.'}));
        assertEquals("///", reverseWords("///", new char[]{'/'}));
        assertEquals("", reverseWords("", new char[]{':'}));
        assertEquals("abc", reverseWords("abc", new char[]{':'}));
    }


}