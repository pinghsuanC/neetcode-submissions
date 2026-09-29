class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.peek() != map.get(c)) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
