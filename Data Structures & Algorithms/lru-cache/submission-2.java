class LRUCache {

    // custom node class for a doubly-linked list (DLL)
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;    
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node target = map.get(key);
        int value = target.val;
        // remove node and add it back
        removeNode(target);
        addNode(target);
        return value;
    }
    
    public void put(int key, int value) {
        // if the current key exists, remove the node associated with it
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        Node newNode = new Node(key, value);
        // add node to the list
        addNode(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    public void addNode(Node newNode) {
        // new nodes are always added to the front of the DLL
        Node nextNode = head.next;
        nextNode.prev = newNode;
        head.next = newNode;
        newNode.next = nextNode;
        newNode.prev = head;
    }

    public void removeNode(Node target) {
        Node prevNode = target.prev;
        Node nextNode = target.next;
        // wire the prev and next together
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
