class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];

        for (int[] courses : prerequisites) {
            int advanced = courses[0];
            int basic = courses[1];
            if (adj[basic] == null) {
                adj[basic] = new ArrayList<>();
            }
            adj[basic].add(advanced);
            inDegree[advanced]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int classesTaken = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int classTaken = queue.poll();
            classesTaken++;
            List<Integer> nextClasses = adj[classTaken];
            if (nextClasses != null) {
                for (int i = 0; i < nextClasses.size(); i++) {
                    int nextClass = nextClasses.get(i);
                    inDegree[nextClass]--;
                    if (inDegree[nextClass] == 0) {
                        queue.offer(nextClass);
                    }
                }
            }
        }
        return classesTaken == numCourses;
    }
}
