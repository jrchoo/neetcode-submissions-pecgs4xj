class Solution {
    public int countComponents(int n, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // track
        boolean[] visited = new boolean[n];
        int numComponents = 0;

        // loop for unvisited islands
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numComponents++;
                visited[i] = true;
            
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll(); 
                    List<Integer> neighbour = adj.get(curr);
                    for (int next : neighbour) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            
        }
         
        return numComponents;
    }
}
