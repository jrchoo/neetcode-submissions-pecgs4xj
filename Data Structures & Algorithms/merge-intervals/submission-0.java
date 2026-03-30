class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) {
            return intervals;
        }
        // Sort according to start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty()) { // only for the first interval
                merged.add(interval);
                continue;
            }

            int start = interval[0];
            int end = interval[1];
            int[] prev = merged.get(merged.size() - 1);

            if (prev[1] < start) {
                merged.add(interval);
            } else {
                prev[1] = Math.max(prev[1], end);
            }
        }
        
        // convert list to array (list<int[]> -> int[][])
        return merged.toArray(new int[merged.size()][]);
    }
}
