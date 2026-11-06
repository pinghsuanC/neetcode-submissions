class Solution {
    public String decodeString(String s) {
        /*
        intuition:
        - it's given that the string is always valid
        - use stack to push characterse onto the stack, and then when encountered closing brancket "]"
            -> pop until "[" for the target substring
            -> pop the digits to get the time

        */

        if(s.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        int n = s.length();
        String CLOSING = "]", OPENING = "[";
        
        for(int i = 0; i < n; i++){
            if(!s.substring(i, i+1).equals(CLOSING)){
                stack.push(s.substring(i, i+1));
                continue;
            }

            // retrieve the target String
            String target = "";
            while(!stack.isEmpty() && !stack.peek().equals(OPENING)){
                target = stack.pop() + target;
            }
            stack.pop();
            // retrieve the digits
            String digits = "";
            while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                digits = stack.pop() + digits;
            }

            String str = "";
            for(int k = 0; k < Integer.valueOf(digits); k++) str += target; // todo: add try catch 
            stack.push(str);
        }

        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }

        return res;
    }
}