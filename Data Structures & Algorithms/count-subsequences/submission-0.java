class Solution {

    private Integer[][] dp;

    public int numDistinct(String s, String t) {
        // how many distinct ways can I build the remaining sequence of string t
        // using the rest of string s
        int m = s.length();
        int n = t.length();
        dp = new Integer[m][n];

        return dfs(s, t, 0, 0);
    }

    public int dfs(String s, String t, int i, int j) {
        if (j == t.length()) { // found a valid subsequence
            return 1;
        }

        if (i == s.length()) { // reached the end without finding a valid subsequence
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int numWays = 0;

        if (s.charAt(i) == t.charAt(j)) { // character matches, can search next index of s
            numWays += dfs(s, t, i + 1, j + 1);
        }
        // option to skip over the current character in s
        numWays += dfs(s, t, i + 1, j);

        dp[i][j] = numWays;
        return dp[i][j];
    }
}
