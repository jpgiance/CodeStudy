package java;

public class ProductOfArrayExceptSelf {
    
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };

        int k = 2;

        System.out.print(answer(nums).toString());

    }

    private static int[] answer(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int post = 1;

        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }

        for (int i =  ans.length - 2; i >= 0; i--) {
            post = post * nums[i+1];
            ans[i] = ans[i] * post;
        }

        return ans;
    }
}
