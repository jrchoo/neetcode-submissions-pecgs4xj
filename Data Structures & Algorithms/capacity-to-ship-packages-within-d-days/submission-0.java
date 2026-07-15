class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }
        // base case: if only given 1 day, the capacity must be the sum of all the weights
        if (days == 1) {
            return sum;
        }
        // otherwise, do binary search on the answer
        int low = max;
        int high = sum;
        int capacity = 0;

        while (low <= high) {
            // serves as the least weight capacity
            int mid = low + (high - low) / 2;
            
            if (isPossible(mid, weights, days)) { // try to find the minimum weight capacity
                capacity = mid;
                high = mid - 1;
            } else { // capacity is too small
                low = mid + 1;
            }
        }

        return capacity;
    }

    private boolean isPossible(int capacity, int[] weights, int days) {
        // takes at least 1 day
        int daysTaken = 1;
        int currentLoad = 0;
        int i = 0;

        for (int weight : weights) {
            if (weight + currentLoad > capacity) { // unable to carry today's weight, try again tomorrow
                currentLoad = 0;
                daysTaken++;
            }

            currentLoad += weight;
        }

        return daysTaken <= days;
    }
}