class Solution {
    public int maxProfit(int[] prices) {
        // on any given day, allowed to buy/sell stock
        // can only sell if currently holding a stock
        // at any given time, can hold onto one stock
        int n = prices.length;
        // at index i, represents max profit while holding a stock on the ith day
        int[] holding = new int[n];
        // at index i, represents max profit while not holding a stock on the ith day 
        int[] notHolding = new int[n]; 

        // base cases
        holding[0] = -prices[0]; // bought a stock on the first day
        notHolding[0] = 0; // did not buy

        for (int i = 1; i < n; i++)  {
            holding[i] = Math.max(holding[i - 1], notHolding[i - 1] - prices[i]);
            notHolding[i] = Math.max(notHolding[i - 1], holding[i - 1] + prices[i]);
        }

        // selling off the stock on the last day guarantees a greater profit than holding onto one
        return notHolding[n - 1];
    }
}