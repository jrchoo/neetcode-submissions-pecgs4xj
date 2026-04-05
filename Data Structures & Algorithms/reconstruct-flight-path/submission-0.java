class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> results = new LinkedList<>();
        // create adjacency list
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        // populate adjacency list
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.putIfAbsent(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }

        dfs("JFK", adj, results);
        return results;
    }

    public void dfs(String from, HashMap<String, PriorityQueue<String>> adj, 
    LinkedList<String> results) {
        PriorityQueue<String> nextFlights = adj.get(from);

        while (nextFlights != null && !nextFlights.isEmpty()) {
            String nextFlight = nextFlights.poll();
            dfs(nextFlight, adj, results);
        }
        
        results.addFirst(from);
    }
}
