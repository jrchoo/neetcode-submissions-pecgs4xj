class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] fleet = new int[n][2];

        for (int i = 0; i < n; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        // sorts arrays according to position
        Arrays.sort(fleet, (a, b) -> Integer.compare(b[0], a[0]));
        double bottleneck = 0.0;
        int fleets = 0;

        for (int[] car : fleet) {
            double timeToTarget = (double) (target - car[0]) / car[1];

            if (timeToTarget > bottleneck) {
                // becomes the new bottleneck
                bottleneck = timeToTarget;
                fleets++;
            }
        }

        return fleets;
    }
}
