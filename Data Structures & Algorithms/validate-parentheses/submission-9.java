class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put('}', '{');
        mp.put(')', '(');
        mp.put(']', '[');
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!mp.keySet().contains(c)){
                stack.push(c);
            } else {
                if(stack.empty() || (stack.pop() != mp.get(c))){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
