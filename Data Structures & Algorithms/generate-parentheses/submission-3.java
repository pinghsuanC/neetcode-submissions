class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        // Intuition
        // note that # of right bracket = n = # left bracket
        // also left bracket is able to be added only when # left < # right
        // using these two rules, we can use back tracking to explore all the subsets
        res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        helper(n, 0, 0, stack);
        return res;
    }
    public void helper(int n, int l, int r, Stack<String> stack){
        if(stack.size() == n*2){
            res.add(String.join("", stack));
            return;
        }

        if(l < n){
            stack.push("(");
            helper(n, l+1, r, stack);
            stack.pop();
        }

        if(r < l){
            stack.push(")");
            helper(n, l, r+1, stack);
            stack.pop();
        }
    }

    private String stackToString(Stack<String> stack){
        String s = "";
        for(int i = 0; i < stack.size(); i++){
            s+=stack.get(i);
        }
        return s;
    }


}
