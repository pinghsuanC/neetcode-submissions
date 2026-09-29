class PrefixTree {
    private class TrieNode{
        public TrieNode[] children;
        public boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }

    }

    TrieNode start;

    public PrefixTree() {
        this.start = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = start;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int ind = c - 'a';
            if(cur.children[ind] == null){
                cur.children[ind] = new TrieNode();
            }
            if(i == word.length() - 1){
                cur.children[ind].isEndOfWord = true;
            }
            cur = cur.children[ind];
        }
    }

    public boolean search(String word) {
        TrieNode cur = start;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int ind = c - 'a';
            if(cur.children[ind] == null) return false;
            if(i == word.length() - 1 && cur.children[ind].isEndOfWord == false) return false;
            cur = cur.children[ind];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = start;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int ind = c - 'a';
            if(cur.children[ind] == null) return false;
            cur = cur.children[ind];
        }
        return true;
    }
}





