package Walmart;

/**
 *  Leetcode 206
 * 
 *  https://leetcode.com/problems/reverse-linked-list/
 * 
 */

public class ReverseLinkedList {

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

        ListNode solution = answer(head1);
        while (solution != null) {
            System.out.print(solution.val + " -> ");
            solution = solution.next;
        }
    }


    private static ListNode answer(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        

        ListNode minusTwoNode = null;
        ListNode minusOneNode = null;


        while (head != null) {
            minusOneNode = new ListNode(head.val, minusTwoNode);
            minusTwoNode = minusOneNode;
            head = head.next;
        }

        return minusOneNode;
    }
    
}
