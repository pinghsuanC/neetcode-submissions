class PrefixTree {
    private class TrieNode{
        public TrieNode[] children;
        public boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26*2];
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
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            if(i == word.length() - 1){
                cur.children[c - 'a'].isEndOfWord = true;
            }
            cur = cur.children[c - 'a'];
        }
    }

    public boolean search(String word) {
        TrieNode cur = start;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            if(i == word.length() - 1 && cur.children[c - 'a'].isEndOfWord == false) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = start;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}





