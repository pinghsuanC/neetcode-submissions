class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n, 0, 0, new Stack<Character>());
        return res;
    }

    public void helper(int n, int open, int close, Stack<Character> set){
        if(open == n && open == close){
            res.add(stackToString(set));
            return;
        }

        if(open < n){
            set.push('(');
            helper(n, open+1, close, set);
            set.remove(set.size() - 1);
        }

        if(open > close){
            set.push(')');
            helper(n, open, close+1, set);
            set.remove(set.size() - 1);
        }
    }

    private String stackToString(Stack<Character> stack){
        String s = "";
        for(char c : stack) s+=c;
        return s;
    }
}
