class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // max heap to store characters and their frequencies (decreasing order)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (x, y) -> y[1] - x[1]
        );
        // put all characters and their frequency into a max heap
        if (a > 0) maxHeap.offer(new int[]{'a', a});
        if (b > 0) maxHeap.offer(new int[]{'b', b});
        if (c > 0) maxHeap.offer(new int[]{'c', c});

        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            // look at the most frequent character
            int[] first = maxHeap.poll();
            char current = (char) first[0];
            int n = result.length();
            // check the previous 2 characters of the string
            if (n >= 2 && current == result.charAt(n - 1) && current == result.charAt(n - 2)) {
                // if same, use the second most frequent character
                if (maxHeap.isEmpty()) { // no other suitable characters
                    break;
                }

                int[] second = maxHeap.poll();
                char letter = (char) second[0];

                result.append(letter);
                // decrement the frequency, and add back onto the heap if there are counts remaining
                second[1]--;

                if (second[1] > 0) {
                    maxHeap.offer(second);
                }
                // add back the unused first character
                maxHeap.offer(first);
            } else { // if not, safely append to the string
                result.append(current);
                first[1]--;

                if (first[1] > 0) {
                    maxHeap.offer(first);
                }
            }
        }
        
        return result.toString();
    }
}