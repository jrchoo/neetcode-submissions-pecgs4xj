class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a valid tree has n nodes and n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        boolean[] visited = new boolean[n];
        // create and populate adjacency list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (!adj.containsKey(node1)) {
                adj.put(node1, new ArrayList<>());
            }
            adj.get(node1).add(node2);

            if (!adj.containsKey(node2)) {
                adj.put(node2, new ArrayList<>());
            }
            adj.get(node2).add(node1);
        }

        // start dfs on the first node
        dfs(0, adj, visited);

        for (boolean b : visited) {
            if (b == false) {
                return false;
            }
        }

        return true;
    }

    // node, adjacency list, visited
    public void dfs(int node, HashMap<Integer, List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        if (!adj.containsKey(node)) {
            return;
        }
        
        List<Integer> neighbours = adj.get(node);
        for (int i = 0; i < neighbours.size(); i++) {
            int nextNode = neighbours.get(i);
            if (visited[nextNode] == false) {
                dfs(nextNode, adj, visited);
            }
        }
    }
}
