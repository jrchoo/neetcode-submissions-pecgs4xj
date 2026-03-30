class Solution {
    public String foreignDictionary(String[] words) {
        // Adjacency list and in degree map
        HashMap<Character, List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // a prefix of the current word cannot appear later in the dictionary
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char first = word1.charAt(j);
                char second = word2.charAt(j);
                if (first == second) { // skip until there is a mismatch
                    continue;
                }
                adj.get(first).add(second);
                inDegree.put(second, inDegree.get(second) + 1);
                break;
            }
        }
        
        // topological sort, nodes with inDegree 0 are added
        Queue<Character> queue = new LinkedList<>();
        for (char key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        StringBuilder alienDictionary = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            alienDictionary.append(current);
            List<Character> neighbours = adj.get(current);
            for (int k = 0; k < neighbours.size(); k++) {
                char nextChar = neighbours.get(k);
                inDegree.put(nextChar, inDegree.get(nextChar) - 1);
                if (inDegree.get(nextChar) == 0) {
                    queue.offer(nextChar);
                }
            }
        }

        return alienDictionary.length() == inDegree.size() 
            ? alienDictionary.toString()
            : ""; 
    }
}
