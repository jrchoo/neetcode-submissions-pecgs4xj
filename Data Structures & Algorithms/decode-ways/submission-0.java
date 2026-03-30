class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        // initialise dp array
        dp[0] = 1; // only 1 way to decode an empty string
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        
        for (int i = 2; i < n + 1; i++) {
            // current digit is not a zero, valid way
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // check the digit before it, non-zero forms a valid combination
            String substring = s.substring(i - 2, i);
            int digits = Integer.parseInt(substring);
            if (digits >= 10 && digits <= 26) {
                dp[i] += dp[i - 2];
            }
                
        }
        return dp[n];
    }
}
