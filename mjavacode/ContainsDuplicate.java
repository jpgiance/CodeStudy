package mjavacode;

import java.util.Arrays;
import java.util.HashSet;

class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        if (nums.length < 2)
            return;
        System.out.print(checkDupliateV2(nums));
    }

    public static boolean checkDupliateV1(int[] nums) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            } else {
                numbers.add(nums[i]);
            }

        }
        return false;
    }

    public static boolean checkDupliateV2(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }

        }
        return false;
    }
}