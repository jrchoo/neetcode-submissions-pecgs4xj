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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        // create a min Heap to store the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            // pass custom comparator into heap
            (a, b) -> Integer.compare(a.val, b.val)
        );
        // add the head of the list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        // pop the node from the heap and assign the next pointer to it
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode nextNode = minHeap.poll();
            if (nextNode.next != null) {
                minHeap.offer(nextNode.next); // add the next node into the heap
            }
            current.next = nextNode;
            current = current.next;
        }
        // return the resulting list
        return dummy.next;
    }
}
