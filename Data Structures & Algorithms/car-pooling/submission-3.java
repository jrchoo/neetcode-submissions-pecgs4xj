class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // sort the trips according to starting locations
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1])); // [numPassengers, from, to]
        // maintain a minHeap to store active trips, in order of ascending end locations
        PriorityQueue<int[]> activeTrips = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        
        int currentCapacity = 0;

        for (int[] nextTrip : trips) {
            int newPassengers = nextTrip[0];
            int nextStart = nextTrip[1];
            // if the current trip's end location coincides with the start location of the next
            while (!activeTrips.isEmpty() && activeTrips.peek()[2] <= nextStart) {
                // drop off the existing passengers
                int currentTrip[] = activeTrips.poll();
                currentCapacity -= currentTrip[0];
            }

            currentCapacity += newPassengers;
            // check if there enough seats to accommodate them
            if (currentCapacity > capacity) { 
                // when there aren't enough seats, return false
                return false;
            }

            activeTrips.offer(nextTrip);
        }
        
        return true;
    }
}