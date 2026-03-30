class WordDictionary {
    WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        this.children = new WordDictionary[26];
        this.isEndOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionary();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary curr = this;
        return dfs(curr, 0, word);
    }

    public boolean dfs(WordDictionary node, int ind, String word) {
        if (ind == word.length()) {
            return node.isEndOfWord;
        }
        char c = word.charAt(ind);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if(dfs(node.children[i], ind + 1, word)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            int index = c - 'a';
            
            if (node.children[index] != null) {
                return dfs(node.children[index], ind + 1, word);
            }
            
            return false;
        }
        
    }
}
