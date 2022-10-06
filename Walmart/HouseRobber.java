package Walmart;


/**
 *  Leetcode 198
 * 
 *  https://leetcode.com/problems/house-robber/
 */

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 5, 2, 1, 5};
        int[] arr1 = {2,7,3,9,1};
        int[] arr2 = {2,7,9,3,1};
        int[] arr3 = {2,7};
        int[] arr4 = {7};
        int[] arr5 = {};

        System.out.println(solution1(arr));
        System.out.println(solution1(arr1));
        System.out.println(solution1(arr2));
        System.out.println(solution1(arr3));
        System.out.println(solution1(arr4));
        System.out.println(solution1(arr5));
    }

    private static int solution1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int max = 0;

        int count = nums[0];
        for (int i = 2; i < nums.length; i+=2) {
            count+= nums[i];
        }
        max = count;

        count = nums[1];
        for (int i = 3; i < nums.length; i+=2) {
            count+= nums[i];
        }
        if (count > max) max = count;

        return max;
    }

    private static int solution(int[] nums){
        int max = 0;



        return max;
    }
}
