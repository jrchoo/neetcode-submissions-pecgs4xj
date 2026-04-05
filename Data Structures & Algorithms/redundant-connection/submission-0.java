class Solution {

    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            // each node is its parent 
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            if (!union(first, second)) { // cycle detected
                return edge;
            }
        }

        return new int[0];
    }

    public int find(int node) {
        // find the parent of the node
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    public boolean union(int u, int v) {
        int parent1 = find(u);
        int parent2 = find(v);

        // if both sets have the same parent, there is a cycle
        if (parent1 == parent2) { 
            return false;
        }

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if (rank1 < rank2) { // attach the first set to the second
            parent[parent1] = parent2;
        } else if (rank1 > 2) { // attach the second set to the first
            parent[parent2] = parent1;
        } else { // same rank, arbitrarily attach the first to the second
            parent[parent1] = parent2;
            rank[parent2]++;
        }

        return true;
    }


}
