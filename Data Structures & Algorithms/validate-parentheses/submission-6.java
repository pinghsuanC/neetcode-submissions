class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put(']', '[');
        mp.put('}', '{');
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mp.containsKey(c)){
                if(!stack.isEmpty() && stack.peek()== mp.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }
        
        return stack.empty();
    }
}
