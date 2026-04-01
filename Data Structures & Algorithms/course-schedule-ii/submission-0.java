class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        // adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int[] course : prerequisites) {
            int advanced = course[0];
            int basic = course[1];
            if (adj[basic] == null) {
                adj[basic] = new ArrayList<>();
            }
            adj[basic].add(advanced);
            inDegree[advanced]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i); // add courses with no prerequisites
            }
        }

        int index = 0;

        while (!queue.isEmpty()) {
            // valid course to take, added to the sequence
            int curr = queue.poll();
            result[index++] = curr;
            if (adj[curr] != null) {
                List<Integer> nextCourses = adj[curr];
                for (int i = 0; i < nextCourses.size(); i++) {
                    int nextCourse = nextCourses.get(i);
                    inDegree[nextCourse]--;
                    // only courses that are eligible are added to the queue
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}
