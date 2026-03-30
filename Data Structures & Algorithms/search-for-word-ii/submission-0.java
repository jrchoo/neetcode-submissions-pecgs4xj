class Solution {
    class TrieNode {
        // Create a trie to store the words
        TrieNode[] children;
        String fullWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public void insert(String word) {
            TrieNode curr = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.fullWord = word;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        // Create and store words in the trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }

        List<String> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // run DFS at every single cell, every cell is a possible starting point
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int row, int col, TrieNode root, List<String> result) {
        int m = board.length;
        int n = board[0].length;
        // base case
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        // visited check
        if (board[row][col] == '#') {
            return;
        }
        
        char c = board[row][col];
        int index = c - 'a';
        if (root.children[index] == null) { // magic pruning, does not exist in the dictionary
            return;
        }
        // moving down the trie
        root = root.children[index];
        // find the word
        if (root.fullWord != null) {
            result.add(root.fullWord);
            root.fullWord = null;
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char temp = board[row][col];
        board[row][col] = '#';

        for (int[] dir : dirs) {    
            int x = row + dir[0];
            int y = col + dir[1];
            dfs(board, x, y, root, result);
        }
        board[row][col] = temp; 
    }
}
