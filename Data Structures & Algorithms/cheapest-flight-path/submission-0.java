class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] curr = new int[n];

        // initialise distance to all other cities to inf except from the starting
        for (int i = 0; i < n; i++) {
            prev[i] = Integer.MAX_VALUE;
            curr[i] = Integer.MAX_VALUE;
        }

        prev[src] = 0;
        curr[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // the cheapest price to get to city i is either an existing path,
                // or taking this current flight
                if (prev[from] != Integer.MAX_VALUE) {
                    curr[to] = Math.min(curr[to], prev[from] + price);
                }
            }
            // update prev with new state before next iteration
            prev = Arrays.copyOf(curr, n);
        }
        

        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }
}
