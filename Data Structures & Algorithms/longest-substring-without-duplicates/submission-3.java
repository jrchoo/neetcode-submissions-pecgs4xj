class Solution {
    public int lengthOfLongestSubstring(String s) {
        // naive approach: try to create the longest substring starting from every
        // index of the string, then compare the lengths of all substrings and 
        // return the longest length
        // time complexity: O(n^2) from repeated comparisons

        // optimised approach: use a sliding window to hold unique characters
        // expands from the right to accomodate new characters
        // when a duplicate character is encountered, shrink the window from the left
        // until the first occurence of this character has been removed
        HashSet<Character> window = new HashSet<>();
        int left = 0;
        int n = s.length();
        int max = 0;

        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            // check if this character has been added before
            // if exists, repeated shrink the window from the left
            while (window.contains(current)) {
                window.remove(s.charAt(left));
                left++;
            }
            // otherwise, safely add into the window
            window.add(s.charAt(right));
            // update the length of the longest substring so far
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
