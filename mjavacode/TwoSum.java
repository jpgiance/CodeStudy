package mjavacode;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        System.out.print(checkTwoSumV1(nums, target).toString());

    }

    public static int[] checkTwoSumV1(int[] nums, int target) {
        int[] result = { 0, 0 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }

        }

        return result;
    }

    public static int[] checkTwoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}
