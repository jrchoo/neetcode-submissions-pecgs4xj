class MyHashSet {

    private class Node {
        public int key;
        public Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    // simple hash function
    public int hash(int key) {
        return key % SIZE;
    }
    
    public void add(int key) {
        int index = hash(key);
        
        // if bucket doesn't exist, create the first new
        if (buckets[index] == null) {
            buckets[index] = new Node(key);
        } else {
            Node curr = buckets[index];
            while (curr != null) {
                if (curr.key == key) { // duplicate already exists
                    return;
                }

                if (curr.next == null) {
                    break;
                }

                curr = curr.next;
            }
            // append the new node
            curr.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        if (curr == null) {
            return;
        }

        // if first node is removed, the next node will be the new head
        if (curr.key == key) {
            buckets[index] = curr.next;
            return;
        }

        // otherwise, search for the target key
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        if (curr == null) { // bucket does not exist
            return false;
        }

        // search the list
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }

            curr = curr.next;
        }
        
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */