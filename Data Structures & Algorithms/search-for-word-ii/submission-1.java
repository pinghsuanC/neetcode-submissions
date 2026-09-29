class Solution {
    private class TrieNode{
        public TrieNode[] children;
        public boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private class TrieTree{
        TrieNode root;
        
        public TrieTree(){
            root = new TrieNode();
        }

        public TrieNode get(){
            return root;
        }

        public void addWord(String s){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                int ind = c - 'a'; // assuming all lower case letters
                if(cur.children[ind] != null) {
                    cur = cur.children[ind];
                    continue;
                }
                cur.children[ind] = new TrieNode();
                cur = cur.children[ind];
            }
            cur.isEnd = true;
        }
    }


    Set<String> res;
    boolean[][] visit;
    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0) return new ArrayList<>();

        res = new HashSet<>();
        int m = board.length, n = board[0].length;
        visit = new boolean[m][n];

        // build a prefix tree for words
        TrieTree tree = new TrieTree();
        for(String s : words){
            tree.addWord(s);
        }

        // search
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                helper(board, r, c, tree.get(), "");
            }
        }
        

        return new ArrayList<>(res);
    }

    private void helper(char[][] board, int r, int c, TrieNode node, String word){
        int m = board.length, n = board[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n || visit[r][c] || node.children[board[r][c] - 'a'] == null){
            return;
        }

        visit[r][c] = true;
        node = node.children[board[r][c] - 'a'];
        word+=board[r][c];
        if(node.isEnd){
            res.add(word);
        }

        helper(board, r+1, c, node, word);
        helper(board, r-1, c, node, word);
        helper(board, r, c+1, node, word);
        helper(board, r, c-1, node, word);

        visit[r][c] = false;
    }
}
