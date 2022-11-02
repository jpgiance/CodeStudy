package java.Walmart;

/**
 * Leetcode 70
 * 
 * https://leetcode.com/problems/climbing-stairs/
 */

public class ClimbingStairs {

    public static void main(String[] args) {

        int n = 5;
        // System.out.println(num_ways(n));
        System.out.println(num_ways_optimal(n));
    }

    private static int num_ways(int n) {
        // Recursive approach
        if (n == 0 || n == 1)
            return 1;
        return num_ways(n - 1) + num_ways(n - 2);
    }

    private static int num_ways_optimal(int n) {
        // bottoms up approach
        if (n == 0 || n == 1)
            return 1;
        int[] seq = { 1, 1 };
        int total = 0;

        for (int i = 2; i <= n; i++) {
            total = seq[0] + seq[1];
            seq[0] = seq[1];
            seq[1] = total;
        }

        return total;
    }

}
