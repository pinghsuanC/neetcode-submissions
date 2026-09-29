class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n, 0, 0, new ArrayList<>());
        return res;
    }

    public void helper(int n, int l, int r, ArrayList<String> string){
        if(l == r && r == n){
            res.add(String.join("", string));
            return;
        }

        if(r < n){
            string.add("(");
            helper(n, l, r+1, string);
            string.remove(string.size() - 1);
        }

        if(l < r){
            string.add(")");
            helper(n, l+1, r, string);
            string.remove(string.size() - 1);
        }


    }
}
