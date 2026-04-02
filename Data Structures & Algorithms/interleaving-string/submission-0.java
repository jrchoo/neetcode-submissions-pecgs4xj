class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // an empty string can be made from 2 empty strings
        for (int i = 1; i < m + 1; i++) {
            if (dp[i - 1][0] == true && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }

        for (int j = 1; j < n + 1; j++) {
            if (dp[0][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // the current interleaved substring of length i + j  in s3
                // is either a valid interleave from dp[i - 1][j] and the current 
                // character at i in s1 matches, or a valid interleave from
                // dp[i][j - 1] and the current character at j in s2 matches
                if ((dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                || dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } 
            }
        }

        return dp[m][n];
    }
}
