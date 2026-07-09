class Solution {
    public String reorganizeString(String s) {
        // array to act as a frequency map for the characters in the string s
        int[] freq = new int[26];
        // iterate through the string and populate the map
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]++;
        }

        // heap to store the indices corresponding to the characters
        // in order of decreasing frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> freq[b] - freq[a] 
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(i);
            }
        }

        StringBuilder result = new StringBuilder(); // sb object to store the final string
        int hold = -1; // variable to hold the recently popped index
        
        while (!maxHeap.isEmpty()) {
            // pop the most frequent character
            int index = maxHeap.poll();
            char letter = (char) (index + 'a');
            // append it to the result
            result.append(letter);
            // decrement its count
            freq[index]--;
            // put the previously held character back into the heap (if freq > 0)
            if (hold != -1 && freq[hold] > 0) {
                maxHeap.offer(hold);
            }
            // make the current character the new held character
            hold = index;
        }
        
        if (result.length() != s.length()) { // impossible to reorganise the input string
            return "";
        }

        return result.toString();
    }
}