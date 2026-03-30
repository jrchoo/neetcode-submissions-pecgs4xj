class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) {
            return false; // s2 cannot contain a substring longer than itself
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < m; i++) {
            char c1 = s1.charAt(i);
            int index1 = c1 - 'a';
            char c2 = s2.charAt(i);
            int index2 = c2 - 'a';
            s1Count[index1]++;
            s2Count[index2]++;
        }
        // check initial window
        if (checkMatches(s1Count, s2Count)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            // swallow the new character and increment count
            char nextChar = s2.charAt(i);
            int newIndex = nextChar - 'a';
            s2Count[newIndex]++;
            // decrement the count for the character leaving the window
            char oldChar = s2.charAt(i - m);
            int oldIndex = oldChar - 'a';
            s2Count[oldIndex]--;

            if (checkMatches(s1Count, s2Count)) {
                return true;
            }
        }
        // no valid substring found
        return false;
    }

    public boolean checkMatches(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}
