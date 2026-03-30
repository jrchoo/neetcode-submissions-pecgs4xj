class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1; // the slowest Koko can eat
        int high = max; // the fastest Koko has to eat

        while (low < high) {
            int mid = low + (high - low) / 2;
            // able to finish
            if (canFinish(piles, h, mid)) {
                // try to find a slower eating rate
                high = mid;
            } else { // unable to finish
                // increase the eating speed
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canFinish(int[] piles, int h, int rate) {
        for (int pile : piles) {
            if (h < 0) {
                return false;
            }
            int time = (pile + rate - 1) / rate; // integer division
            h -= time;
        }

        return h >= 0;
    }
}
