class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            freq1[index]++;
            c = t.charAt(i);
            index = c - 'a';
            freq2[index]++;
        }

        for (int j = 0; j < 26; j++) {
            if (freq1[j] != freq2[j]) {
                return false;
            }
        }
        return true;
    }
}
