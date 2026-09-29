class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else{
                if(stack.empty()){ return false;}
                char p = stack.peek();
                if((c==')' && p == '(') || (c=='}' && p=='{') || (c==']' && p=='[')){
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
}
