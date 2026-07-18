class Solution {
    public int characterReplacement(String s, int k) {
        // naive approach: try every combination of replacing existing characters
        // with k instances of the most frequent character
        // checking every possible substring results in a O(n^2) runtime

        // optimised approach: use a sliding window and keep track of the frequency
        // of the character that appears the most often, the mathematical maximum
        // length of a substring where all characters are identical is given by
        // the frequency of the character that appears the most + k
        // therefore, the size of the window should be freq(mostFreqChar) + k
        int[] freq = new int[26];
        int mostFrequent = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            int index = current - 'A';
            freq[index]++;
            mostFrequent = Math.max(mostFrequent, freq[index]);
            // theoretical max length of window = mostFrequent + k
            // windowLength - mostFrequent <= k
            // window size grows by at most 1 with each iteration
            // only have to evict one character from the window
            if ((right - left + 1 - mostFrequent) > k) {
                // evict characters from the left of the window
                char toEvict = s.charAt(left);
                int charIndex = toEvict - 'A';
                freq[charIndex]--;
                left++;
            }
            // compare historical max with current window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
