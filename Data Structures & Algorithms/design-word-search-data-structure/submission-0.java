class WordDictionary {
    private class TrieNode{
        public TrieNode[] children;
        public boolean isEndOfWord;

        public TrieNode(){
            children = new TrieNode[26];
            isEndOfWord = false;
        }

        // note: omitting setters and getters for convenience, but it should be in getter and setter if have time
    }

    private TrieNode start;


    public WordDictionary() {
        start = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = start;
        for(char c : word.toCharArray()){
            int pos = c - 'a';
            if(cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {

        return dfs(word, 0, start);
    }

    private boolean dfs(String word, int j, TrieNode root){
        TrieNode cur = root;
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : cur.children){
                    if(child == null) continue;
                    if(dfs(word, i+1, child)) return true;
                }
                return false;
            } else {
                if(cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
        }

        return cur.isEndOfWord;
    }
}
