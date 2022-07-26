package Walmart;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  Leetcode 2
 * 
 *  https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 */

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        
    
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode head2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode solution = answer(head1, head2);
        while (solution != null) {
            System.out.print(solution.val + " -> ");
            solution = solution.next;
        }
    }





    private static ListNode answer(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode();
        ListNode newHeadTemp = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newHeadTemp.next = head1;
                head1 = head1.next;
            } else {
                newHeadTemp.next = head2;
                head2 = head2.next;
            }
            newHeadTemp = newHeadTemp.next;
        }
        if (head1 != null) {
            newHeadTemp.next = head1;
        } else if (head2 != null) {
            newHeadTemp.next = head2;
        }

        return newHead.next;
    }







    
}




 
