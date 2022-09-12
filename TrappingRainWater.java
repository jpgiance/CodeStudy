import java.util.Arrays;

/**
 * Leetcode 42
 * 
 * https://leetcode.com/problems/trapping-rain-water/
 */

public class TrappingRainWater {
    
    public static void main(String[] args) {

        int[] height = {4,2,0,3,2,5};
        
        System.out.println(solution1(height));
    }

    private static int solution1(int[] height){
        
        int total = 0;
        int maxL = 0, maxR = 0;
        int[] max = new int[height.length];
        Arrays.fill(max, 0);
        
        for (int i = 0; i < height.length; i++) {
            max[i] = maxL;
            if (height[i] > maxL) maxL = height[i]; 
        }

        for (int i = height.length - 1; i >= 0; i--) {
            max[i] = Math.min(max[i], maxR);
            if (height[i] > maxR) maxR = height[i]; 
        }

        for (int i = 0; i < height.length; i++) {
            if (height[i] < max[i]) total += max[i] - height[i]; 
        }

        return total;
    }

    private static int solution(int[] height) {
        int total = 0;
        int maxL = 0;
        int maxR = 0;
        int pointerL = 0;
        int pointerR = height.length - 1;

        while (pointerL < pointerR) {
            if (height[pointerL] <= height[pointerR]) {
                if (height[pointerL] < maxL) {
                    total += maxL - height[pointerL];
                    pointerL++;
                } else {
                    maxL = height[pointerL];
                    pointerL++;
                }
            } else {
                if (height[pointerR] < maxR) {
                    total += maxR - height[pointerR];
                    pointerR--;
                } else {
                    maxR = height[pointerR];
                    pointerR--;
                }
            }
        }


        return total;
    }

}
