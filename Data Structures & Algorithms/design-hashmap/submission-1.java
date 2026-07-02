class MyHashMap {
    // private Node class to hold key, value pairs
    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];    
    }
    
    // simple hash function
    public int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        // hash the key to find the index, traverse the linked list
        int index = hash(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
        } else {
            // if key is present, update the value
            Node curr = buckets[index];
            while (curr != null) {
                if (curr.key == key) { // found the target key
                    curr.value = value;
                    return;
                }

                if (curr.next == null) {
                    break;
                }

                curr = curr.next;
            }
            // reached the end of the list, append a new key/value pair
            curr.next = new Node(key, value);
        }
    }
    
    public int get(int key) {
        // hash the key, traverse the linked list
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }

        Node curr = buckets[index];
        
        while (curr != null) {
            if (curr.key == key) { // if key is found, return value
                return curr.value;
            }

            curr = curr.next;
        }
        // otherwise, return -1
        return -1;
    }
    
    public void remove(int key) {
        // hash the key, traverse the linked list
        int index = hash(key);
        Node curr = buckets[index];

        if (curr == null) {
            return;
        }

        if (curr.key == key) { // if target key is the head of the list, set the next node to be the new head
            buckets[index] = curr.next;
            return;
        }
        // otherwise, ensure the node just before the target node is pointing to the node after the target
        while (curr.next != null) {
            if (curr.next.key == key) { // found the target key
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */