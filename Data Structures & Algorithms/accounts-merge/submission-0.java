class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // two accounts only belong to the same person if they have an email
        // in commmon, two accounts with the same name may not belong to the same
        // person
        // have an adjacency list that links an email to all other emails of the same
        // account
        Map<String, List<String>> emails = new HashMap<>();
        // a separate map to link an email to the user's name
        Map<String, String> emailToName = new HashMap<>();

        // iterate through the list of accounts
        for (List<String> account : accounts) {
            // process the information within each account
            // first element is always the name
            String name = account.get(0);
            String firstEmail = account.get(1);
            int size = account.size();

            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                // each account is guaranteed to have at least one email
                // create a link from the email to the name
                emailToName.put(email, name);
                // every email should exist as a key in the graph
                emails.putIfAbsent(email, new ArrayList<>());
                if (i > 1) {
                    // bidrectional
                    emails.get(firstEmail).add(email);
                    emails.get(email).add(firstEmail);    
                }
            }
        }
        
        // adjacency list has been populated, begin traversal
        // list to store the final results
        List<List<String>> results = new ArrayList<>();
        // set to keep track of visited emails
        Set<String> visited = new HashSet<>();
        // iterate through all the keys in the emails map
        for (String email : emails.keySet()) {
            // list to store intermediate results
            List<String> neighbours = new ArrayList<>();
            // if an email hasn't been visited, launch a DFS to collect all connected emails
            if (!visited.contains(email)) {
                dfs(emails, email, neighbours, visited);
                // sort that list, append the owner's name at the front
                Collections.sort(neighbours);
                neighbours.add(0, emailToName.get(email));
                // and add to the result
                results.add(neighbours);
            }
        }
        
        return results;
    }

    public void dfs(Map<String, List<String>> emails, String currentEmail, List<String> neighbours,
        Set<String> visited) {
        // set current email to visited
        visited.add(currentEmail);
        // add to the list of neighbours
        neighbours.add(currentEmail);
        // traverse the graph to visit all neighbours
        for (String neighbour : emails.get(currentEmail)) {
            if (!visited.contains(neighbour)) {
                dfs(emails, neighbour, neighbours, visited);
            }
        }
    }
}