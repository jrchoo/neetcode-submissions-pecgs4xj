class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int windowLength = 0;
        int maxFreq = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int index = c - 'A';
            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);
            // if the window excluding the most frequent char exceeds k  
            while ((right - left + 1 - maxFreq) > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            windowLength = Math.max(windowLength, right - left + 1);
        }
        return windowLength;
    }
}
