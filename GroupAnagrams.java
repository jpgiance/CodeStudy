import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.print(groupV2(strings).toString());

    }

    public static List<List<String>> groupV3(String[] strs) {

        HashMap<List<Integer>, List<String>> map = new HashMap<>();

        for (String string : strs) {
            Integer[] counts = new Integer[26];
            Arrays.fill(counts, 0);
            for (Character character : string.toCharArray()) {
                counts[character - 'a'] += 1;
            }
            map.putIfAbsent(Arrays.asList(counts), new ArrayList<>());
            map.get(Arrays.asList(counts)).add(string);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupV2(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String string : strs) {

            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(string);

        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupV1(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            if (!findGroup(str, result))
                result.add(new ArrayList<String>(Arrays.asList(str)));

        }

        // String[][] output = new String[result.size()][];
        // for (int i = 0; i < result.size(); i++) {
        // List<String> row = result.get(i);
        // output[i] = row.toArray(new String[row.size()]);
        // }
        return result;
    }

    private static boolean findGroup(String str, List<List<String>> result) {
        for (List<String> arrayList : result) {
            if (areAnagrams(arrayList.get(0), str)) {
                arrayList.add(str);
                return true;
            }
        }
        return false;
    }

    public static boolean areAnagrams(String s, String t) {
        if (s.equals(t))
            return true;
        if (s.length() != t.length())
            return false;

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
