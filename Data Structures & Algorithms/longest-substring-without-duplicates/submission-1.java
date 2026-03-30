class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;

        while (right < n) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1); // jump to the index after the current
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
