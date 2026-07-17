class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] course : prerequisites) {
            int pre = course[0];
            int post = course[1];
            // pre unlocks the post
            adj.get(pre).add(post);
        }
        // prerequisite (visited) array
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        // run bfs from every node
        for (int i = 0; i < numCourses; i++) {
            bfs(i, adj, isPrerequisite);
        }
        // compare query with prerequisite array
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (isPrerequisite[u][v]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    private void bfs(int index, List<List<Integer>> adj, boolean[][] isPrerequisite) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> neighbours = adj.get(curr);

            for (int neighbour : neighbours) {
                if (!isPrerequisite[index][neighbour]) { // discovered a new path
                    isPrerequisite[index][neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        
    }
}