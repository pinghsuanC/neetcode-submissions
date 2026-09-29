class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<String>();
        Stack<Character> stack = new Stack<>();
        helper(n, 0, 0, stack);
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
            set.pop();
        }

        if(close < open){
            set.push(')');
            helper(n, open, close+1, set);
            set.pop();
        }
    }

    public String stackToString(Stack<Character> set){
        String s = "";
        for(char c : set){
            s+=c;
        }
        return s;
    }
}
