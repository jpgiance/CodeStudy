package java;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "gnaaram";

        System.out.print(checkAnagramV2(s, t));

    }

    public static boolean checkAnagramV1(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> set = new HashMap<>();
        for (Character character : s.toCharArray()) {
            set.put(character, set.get(character) == null ? 1 : set.get(character) + 1);
            System.out.print(character + "\n");
        }
        for (Character character : t.toCharArray()) {
            if (set.containsKey(character) && set.get(character) > 0) {
                System.out.print(character + "\n");
                set.put(character, set.get(character) - 1);
            } else
                return false;
        }

        return true;
    }

    public static boolean checkAnagramV2(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.equals(t))
            return true;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for (Character c : sMap.keySet()) {
            if (!sMap.get(c).equals(tMap.get(c)))
                return false;
        }
        return true;
    }
}
