class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){ return Integer.parseInt(tokens[0]); }
        Stack<String> stack = new Stack<>();
        List<String> ops = new ArrayList<>();
        ops.add("*");
        ops.add("+");
        ops.add("-");
        ops.add("/");
        int res = 0;
        for(int i = 0; i<tokens.length; i++){
            String item = tokens[i];
            if(!ops.contains(item)){
                // add to stack
                stack.add(item);
                
                continue;
            }
            // if it's operant, pop out the stack
            res = Integer.parseInt(stack.pop());
            String other = stack.pop();
            if(item.equals("*")){
                res*=Integer.parseInt(other);
            } else if (item.equals("+")){
                res+=Integer.parseInt(other);
            }
            else if (item.equals("-")){
                res=Integer.parseInt(other) - res;
            }
            else if (item.equals("/")){
                res =Integer.parseInt(other) / res;
            }
            stack.push("" + res);
        }
       

        return res;
    }
}
