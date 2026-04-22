class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // empty string matches another empty string

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') { // search for '*' operators
                dp[0][j] = dp[0][j - 2]; 
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) 
                || p.charAt(j - 1) == '.') { // direct match or '.' match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*'){ // '*' encountered
                    // case 1: 0 occurrences of the preceding character
                    boolean zeroOccurrences = dp[i][j - 2]; // look 2 positions behind
                    boolean oneOrMoreOccurrences = false;
                    // case 2: either the preceding character matches or is a '.'
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        // the string excluding the current character matches the pattern up to j
                        oneOrMoreOccurrences = dp[i - 1][j];
                    }

                    dp[i][j] = zeroOccurrences || oneOrMoreOccurrences;
                }
            }
        }

        return dp[m][n];
    }
}
