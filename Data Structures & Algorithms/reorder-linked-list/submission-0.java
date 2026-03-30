/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        // traverse to mid and end of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half of list
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = reverse(secondHalf);

        // merge the two lists
        while (head != null && secondHalf != null) {
            ListNode next1 = head.next;
            head.next = secondHalf;
            ListNode next2 = secondHalf.next;
            secondHalf.next = next1;
            head = next1;
            secondHalf = next2;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
