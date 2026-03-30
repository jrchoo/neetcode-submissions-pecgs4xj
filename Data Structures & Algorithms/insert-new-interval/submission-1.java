class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();

        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end < newInterval[0]) {
                results.add(new int[]{start, end});
                i++;
            } else {
                break;
            }
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            int start = intervals[i][0];
            int end = intervals[i][1];
           
            newInterval[0] = Math.min(newInterval[0], start);
            newInterval[1] = Math.max(newInterval[1], end);
            i++;
        }
        results.add(newInterval);

        while(i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            results.add(new int[]{start, end});
            i++;
        }

        return results.toArray(new int[results.size()][]);
    }
}
