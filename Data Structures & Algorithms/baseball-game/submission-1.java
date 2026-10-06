class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String s : operations){
            System.out.println(stack);
            if(stack.isEmpty()){
                stack.push(Integer.valueOf(s));
                continue;
            }

            if("+".equals(s)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
            } else if("c".equalsIgnoreCase(s)){
                stack.pop();
            } else if("d".equalsIgnoreCase(s)) {
                int a = stack.peek();
                stack.push(a*2);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        return sum;
    }
}