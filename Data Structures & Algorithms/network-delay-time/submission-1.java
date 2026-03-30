class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        // build adjacency list
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int source = times[i][0];
            int target = times[i][1];
            int time = times[i][2];
            if (!map.containsKey(source)) {
                map.put(source, new ArrayList<>());
            }
            map.get(source).add(new int[]{target, time});
        }

        queue.offer(new int[]{k, 0});
        Set<Integer> visited = new HashSet<>();
        int max = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int time = curr[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            max = Math.max(max, time);
            if (map.containsKey(node)) {
                for (int[] neighbour : map.get(node)) {
                    int next = neighbour[0];
                    int nextTime = neighbour[1];
                    queue.offer(new int[]{next, nextTime + time});
                }
            }
        }
        return visited.size() == n ? max : -1;
    }
}
