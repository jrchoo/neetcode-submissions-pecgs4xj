class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        
        int[] notHolding = new int[n];
        int[] holding = new int[n];

        // base cases
        notHolding[0] = 0;
        holding[0] = -prices[0];
        notHolding[1] = Math.max(notHolding[0], holding[0] + prices[1]);
        holding[1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < n; i++) {
            // not holding yesterday, did nothing today
            // held a stock yesterday, sold for today's price
            notHolding[i] = Math.max(notHolding[i - 1], holding[i - 1] + prices[i]);
            // held a stock yesterday, did nothing today
            // bought a stock today, couldn't have sold yesterday (look at 2 days prior)
            holding[i] = Math.max(holding[i - 1], notHolding[i - 2] - prices[i]);
        }

        return Math.max(notHolding[n - 1], holding[n - 1]);
    }
}
