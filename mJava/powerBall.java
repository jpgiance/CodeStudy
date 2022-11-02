package java;

import java.util.Arrays;
import java.util.Random;

public class powerBall {
    public static void main(String[] args) {
        int[] roll = { 14, 22, 42, 46, 52, 24 };
        int epoch = 0;
        int[] nums = new int[69];
        int[] powerB = new int[26];
        Arrays.setAll(nums, p -> p + 1);
        Arrays.setAll(powerB, p -> p + 1);

        while (!Arrays.equals(roll, generate(nums, powerB))) {
            epoch++;
            System.out.println(epoch);
        }

        System.out.println(epoch);

        // for (int i = 0; i < epoch; i++) {
        // int[] newRoll = generate(nums, powerB);
        // for (int j : newRoll) {
        // System.out.print(" " + j);
        // }
        // System.out.print("\n");

        // }

    }

    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int rand = random.nextInt(array.length);
            int holder = array[i];
            array[i] = array[rand];
            array[rand] = holder;
        }

    }

    public static int[] generate(int[] nums, int[] powerB) {
        int[] roll = new int[6];
        shuffle(nums);
        shuffle(powerB);

        Random random = new Random();
        int index = random.nextInt(69);
        for (int i = 0; i < 5; i++) {
            if (index + i > 68)
                index = 0;
            roll[i] = nums[index + i];
        }
        roll[5] = Integer.MAX_VALUE;
        Arrays.sort(roll);
        roll[5] = powerB[random.nextInt(26)];

        return roll;
    }

}
