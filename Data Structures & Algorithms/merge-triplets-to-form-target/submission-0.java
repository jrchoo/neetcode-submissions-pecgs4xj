class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // running maximum
        int maxA = 0;
        int maxB = 0;
        int maxC = 0;
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                // skip a triplet that exceeds any of the target values
                continue;
            }
            maxA = Math.max(maxA, triplet[0]);
            maxB = Math.max(maxB, triplet[1]);
            maxC = Math.max(maxC, triplet[2]);
        }

        return maxA == target[0] && maxB == target[1] && maxC == target[2];
    }
}
