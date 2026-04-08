class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;

        // sort intervals in order of ascending start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // bind query values with their index in the original array
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        // sort queries in order of ascending value
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] output = new int[m];
        int intervalIndex = 0;

        for (int i = 0; i < m; i++) {
            int query = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            // only intervals with start time before or at the query time are added
            while (intervalIndex < n && intervals[intervalIndex][0] <= query) {
                int[] currInterval = intervals[intervalIndex];
                int start = currInterval[0];
                int end = currInterval[1];
                int length = end - start + 1;
                minHeap.offer(new int[]{length, end});
                intervalIndex++;
            }
            
            // if end time is before query, invalid
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                output[originalIndex] = minHeap.peek()[0];
            } else {
                output[originalIndex] = -1;
            }
        }

        return output;
    }
}
