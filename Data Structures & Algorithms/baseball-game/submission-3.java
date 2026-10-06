class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for(String s : operations){
            if("+".equals(s)){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a+b);
                res+=stack.peek();
            } else if("c".equalsIgnoreCase(s)){
                res-=stack.pop();
            } else if("d".equalsIgnoreCase(s)) {
                stack.push(stack.peek()*2);
                res+=(stack.peek());
            } else {
                stack.push(Integer.parseInt(s));
                res+=stack.peek();
            }
        }

        return res;
    }
}