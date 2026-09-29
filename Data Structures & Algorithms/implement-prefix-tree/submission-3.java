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
        for(char c : word.toCharArray()){
            int ind = c - 'a';
            if(cur.children[ind] == null){
                cur.children[ind] = new TrieNode();
            }
            cur = cur.children[ind];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = start;
        for(char c : word.toCharArray()){
            int ind = c - 'a';
            if(cur.children[ind] == null) return false;
            cur = cur.children[ind];
        }
        return cur.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = start;
        for(char c : prefix.toCharArray()){
            int ind = c - 'a';
            if(cur.children[ind] == null) return false;
            cur = cur.children[ind];
        }
        return true;
    }
}





