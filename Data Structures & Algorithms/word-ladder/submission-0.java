class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        // generate wildcard words
        for (String word : wordList) {
            List<String> wildcards = generateWildCard(word);
            for (String wildcard : wildcards) {
                if (!map.containsKey(wildcard)) {
                    map.put(wildcard, new ArrayList<>());
                }
                // map wildcard words to their original words
                map.get(wildcard).add(word);
            }
        }
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int numWords = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) { // found the target, return numWords
                    return numWords;
                }
                // generate wildcards
                List<String> wildcards = generateWildCard(current);
                // search for next word and add to queue
                for (String wildcard : wildcards) {
                    if (map.containsKey(wildcard)) {
                        List<String> neighbours = map.get(wildcard);
                        for (String neighbour : neighbours) {
                            if (!visited.contains(neighbour)) {
                                queue.offer(neighbour);
                            }
                            visited.add(neighbour);
                        }
                    }
                }
            }

            numWords++;
        }

        // exhausted all combinations but did not find a suitable transformation
        return 0;
    }

    public List<String> generateWildCard(String original) {
        List<String> wildcards = new ArrayList<>();
        int n = original.length();
        char[] letters = original.toCharArray();

        for (int i = 0; i < n; i++) {
            char temp = letters[i];
            letters[i] = '*';
            // create a copy and add to list
            String wildcard = new String(letters);
            wildcards.add(wildcard);

            letters[i] = temp; 
        }

        return wildcards;
    }
}
