class PrefixTree {
    PrefixTree[] children;
    boolean isEndOfWord;

    public PrefixTree() {
        children = new PrefixTree[26];
        isEndOfWord = false;     
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new PrefixTree();    
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
