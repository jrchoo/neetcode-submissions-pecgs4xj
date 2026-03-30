class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int surplus = gas[i] - cost[i];
            totalSurplus += surplus;
            currentSurplus += surplus;
            if (currentSurplus < 0) {
                startIndex = i + 1; // all stations up to i are not valid starting points
                currentSurplus = 0; // reset
            }
        }

        return totalSurplus < 0 ? -1 : startIndex;
    }
}
