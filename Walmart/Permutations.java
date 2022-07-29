package Walmart;

import java.util.ArrayList;
import java.util.List;

/**
 *  Leetcode 46
 * 
 *  https://leetcode.com/problems/permutations/
 */

public class Permutations {

    public static void main(String[] args) {
        permute(new int[]{6, 9, 7, 5}, 0, new ArrayList<>());
    }

    private static void permute(int[] num, int level, List<List<Integer>> answer){

        if (level == num.length) {
            List<Integer> newPermutation = new ArrayList<>();
            for (int n : num) {
                newPermutation.add(n);
                System.out.print(n);
            }
            System.out.println();
            answer.add(newPermutation);
            return;
        }

        for (int i = level; i < num.length; i++) {
            swap(num, level, i);
            permute(num, level+1, answer);
            swap(num, level, i);
        }
    }

    // swap without using temporary variable
    private static void swap(int[] array, int a, int b){
        if (a == b) return;

        array[a] = array[b] - array[a];
        array[b] = array[b] - array[a];
        array[a] = array[a] + array[b]; 

    }
    
}
