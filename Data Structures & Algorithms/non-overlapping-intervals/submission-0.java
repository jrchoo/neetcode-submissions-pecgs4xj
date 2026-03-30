class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort the intervals in ascending start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removed = 0;
        int prevEnd = intervals[0][1]; // initialise to end of first interval

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // check the start time of the current interval against the previous end time
            if (start < prevEnd) { 
                // greedily remove the interval with the later end time
                prevEnd = Math.min(prevEnd, end);
                removed++;
            } else {
                prevEnd = end;
            }
        }
        return removed;
    }
}
