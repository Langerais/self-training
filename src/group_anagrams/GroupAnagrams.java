package group_anagrams;

import java.util.*;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            int[] count = new int[26];

            for(char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder();

            for(int i : count) sb.append(i + '#');

            String key = sb.toString();
            map.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }



}
