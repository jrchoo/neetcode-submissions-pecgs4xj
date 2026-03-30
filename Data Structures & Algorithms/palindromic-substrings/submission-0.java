class Solution {
    public int countSubstrings(String s) {
        int finalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int count1 = expandFromCenter(s, i, i);
            int count2 = expandFromCenter(s, i, i + 1);
            finalCount = finalCount + count1 + count2;
        }
        return finalCount;
    }

    public int expandFromCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
