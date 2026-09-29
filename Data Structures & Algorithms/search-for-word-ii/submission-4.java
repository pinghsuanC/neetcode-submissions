class Solution {
    private class TrieNode{
        public TrieNode[] children;
        public boolean isEnd;
        public int idx;
        public int refs;

        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
            idx = -1;
            refs = 0;
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

        public void addWord(String s, int i){
            TrieNode cur = root;
            cur.refs++;
            for(char c : s.toCharArray()){
                int ind = c - 'a'; // assuming all lower case letters
                if(cur.children[ind] == null) {
                    cur.children[ind] = new TrieNode();
                }
                cur = cur.children[ind];
                cur.refs++;
            }
            cur.idx = i;
        }
    }

    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieTree tree = new TrieTree();
        for(int i = 0; i < words.length; i++){
            tree.addWord(words[i], i);
        }
        TrieNode root = tree.get();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, words);
            }
        }
        
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String[] words){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
            board[r][c] == '*' ||
            node.children[board[r][c] - 'a'] == null){
            return;
        }

        char temp = board[r][c];
        board[r][c] = '*';

        TrieNode parent = node;
        node = node.children[temp - 'a'];

        if(node.idx != -1){
            res.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if(node.refs == 0){
                node = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(board, r + 1, c, node, words);
        dfs(board, r - 1, c, node, words);
        dfs(board, r, c + 1, node, words);
        dfs(board, r, c - 1, node, words);

        board[r][c] = temp;
    }


}
