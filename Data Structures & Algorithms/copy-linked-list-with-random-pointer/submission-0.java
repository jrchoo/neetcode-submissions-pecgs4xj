/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node copy = head;

        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }
            if (head.next != null && !map.containsKey(head.next)) {
                map.put(head.next, new Node(head.next.val));
            }
            if (head.random != null && !map.containsKey(head.random)) {
                map.put(head.random, new Node(head.random.val));
            }

            Node curr = map.get(head);
            curr.next = map.get(head.next);
            curr.random = map.get(head.random);

            head = head.next;
        }

        return map.get(copy);
    }
}
