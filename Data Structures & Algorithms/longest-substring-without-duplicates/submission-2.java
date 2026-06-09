class Solution {
    public int lengthOfLongestSubstring(String s) {
        // use a set to track the characters in the window
        Set<Character> window = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            // window contains the character
            while (window.contains(current)) { // keep evicting characters from the left until the duplicate
                window.remove(s.charAt(left));
                left++;
            }
            // window does not contain the character
            window.add(current);
            // update max
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
