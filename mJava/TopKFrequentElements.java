package java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };

        int k = 2;

        System.out.print(topKV1(nums, k).toString());

    }

    private static int[] topKV1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        }
        List<Map.Entry<Integer, Integer>> results = new ArrayList<>(map.entrySet());
        Collections.sort(results, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        int[] output = new int[k];

        for (int i = results.size() - 1, j = 0; j < k; i--, j++) {
            output[j] = results.get(i).getKey();
        }

        return output;
    }

}