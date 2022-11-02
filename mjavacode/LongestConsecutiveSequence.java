package mjavacode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.print(answer(nums));
    }

    private static int answer(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int maxSeq = 0, tempSeq = 0;
        int head, tail;

        for (int integer : nums) {
            set.add(integer);
        }

        for (int integer : nums) {

            if (set.isEmpty())
                return maxSeq;

            tempSeq = 1;

            // find tail
            tail = integer + 1;
            while (set.contains(tail)) {
                tempSeq++;
                set.remove(tail);
                tail++;
            }

            // find head
            head = integer - 1;
            while (set.contains(head)) {
                tempSeq++;
                set.remove(head);
                head--;
            }

            set.remove(integer);
            if (tempSeq > maxSeq) {
                maxSeq = tempSeq;
            }

        }

        return maxSeq;
    }

}
