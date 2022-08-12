package Walmart;

/**
 *  Leetcode 283
 * 
 *  https://leetcode.com/problems/move-zeroes/
 */

public class MoveZeroes {

    public static void main(String[] args) {
        
    
        int[] nums = {0, 1, 0, 3, 12};

        answer(nums);

        for ( int i : nums) {
            System.out.print(i);

        }
        System.out.println();
     
    }

    private static void answer(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i-count] = nums[i];
            }
        }

        for (int i = 0; i < count; i++) {
            nums[nums.length - 1 - i] = 0;
        }
    }
    
}
