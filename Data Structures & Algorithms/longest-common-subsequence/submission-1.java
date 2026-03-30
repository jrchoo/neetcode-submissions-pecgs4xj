class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // swap the two inputs
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int len = Math.min(m, n) + 1;
        int[] previousRow = new int[len];
        int[] currentRow = new int[len];
        // iterate through both strings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // character match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // diagonally to the left
                    currentRow[j] = 1 + previousRow[j - 1];
                } else { // characters do not match
                    // check left and directly above
                    currentRow[j] = Math.max(currentRow[j - 1], previousRow[j]);
                }
            }
            int[] temp = previousRow;
            previousRow = currentRow;
            // placeholder for old values, gets overwritten in the next iteration
            currentRow = temp;

        }

        return previousRow[len - 1];
    }
}
