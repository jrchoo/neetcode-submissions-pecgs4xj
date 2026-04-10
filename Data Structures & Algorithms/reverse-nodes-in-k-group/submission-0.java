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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy; // the node just before the next k-group

        while (true) {
            // check if there are at least k nodes ahead
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) {
                break; // leave the nodes as they are
            }

            // store the start of the next group
            ListNode groupNext = kthNode.next;
            // reverse the current k-group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            // update groupPrev's next pointer to the new head
            ListNode temp = groupPrev.next; // the original head is now the tail 
            groupPrev.next = kthNode;
            // update groupPrev pointer
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
