package mjavacode.Walmart;


import java.util.HashMap;
import java.util.Map;

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
        int[] arr5 = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};


//        System.out.println(solution(arr));
//        System.out.println(solution(arr1));
//        System.out.println(solution(arr2));
//        System.out.println(solution(arr3));
//        System.out.println(solution(arr4));
//        System.out.println(solution2(arr5));
        System.out.println(rob(arr5));
    }

    private static int notASolution(int[] nums) {
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

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] max = {0};

        step(0, nums, 0, max);
        step(1, nums, 0, max);



        return max[0];
    }

    private static void step(int pos, int[] nums, int carriedCount, int[] max){
        int count = carriedCount;

        if ((pos+2) >= nums.length){
            count += nums[pos];
            max[0] = Math.max(max[0], count);
        }else{
            count += nums[pos];
            for (int i = pos+2; i < nums.length; i++) {
                step(i, nums, count, max);
            }
        }

    }


    private static int solution2(int[] nums){

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        Map<Integer, Integer> maxPerPosition = new HashMap<>();

        return Math.max(step2(0, nums,  maxPerPosition), step2(1, nums, maxPerPosition));
    }

    private static int step2(int pos, int[] nums, Map<Integer, Integer> map){
        if (map.containsKey(pos))
            return map.get(pos);

        int max = 0;

        if ((pos + 2) < nums.length) {

            for (int i = pos+2; i < nums.length; i++) {
                max = Math.max(max, step2(i, nums, map));
            }
        }
        map.put(pos, max + nums[pos]);
        return map.get(pos);
    }





    public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int temp = Math.max(second, first+nums[i]);
            first = second;
            second = temp;
        }

        return second;
    }
}
