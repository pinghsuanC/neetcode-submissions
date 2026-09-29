class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){ return Integer.parseInt(tokens[0]); }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<tokens.length; i++){
            String item = tokens[i];
            if(!"+*-/".contains(item)){
                // add to stack
                stack.add(Integer.parseInt(item));
                
                continue;
            }
            // if it's operant, pop out the stack
            int a = stack.pop();
            int b = stack.pop();
            int res;
            if(item.equals("*")){
                res = a*b;
            } else if (item.equals("+")){
                res = a+b;
            }
            else if (item.equals("-")){
                res= b-a;
            }
            else {
                res= b/a;
            }
            stack.push(res);
        }
       

        return stack.pop();
    }
}
