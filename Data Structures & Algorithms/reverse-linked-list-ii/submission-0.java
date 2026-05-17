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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next;

        ListNode nodeBeforeSublist = prev;
        ListNode sublistTail = curr;

        int count = right - left + 1;
        while (count != 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }
        // prev is pointing to the new head of the sublist
        nodeBeforeSublist.next = prev;
        // curr is pointing to node right after the tail of the sublist
        sublistTail.next = curr;

        return dummy.next;
    }
}