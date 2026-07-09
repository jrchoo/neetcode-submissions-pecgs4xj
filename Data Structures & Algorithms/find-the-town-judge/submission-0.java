class Solution {
    public int findJudge(int n, int[][] trust) {
        // maintain an array to track the net score of each person
        int[] trustScore = new int[n];

        for (int[] relationship : trust) {
            int a = relationship[0] - 1;
            int b = relationship[1] - 1;

            trustScore[a]--; // lose a point when trusting another person
            trustScore[b]++; // gain a point when another person trusts
        }

        // everybody trusts the town judge so the town judge will have a score of n-1
        for (int i = 0; i < n; i++) {
            if (trustScore[i] == n - 1) {
                return i + 1;
            }
        }

        // town judge could not be found
        return -1;
    }
}