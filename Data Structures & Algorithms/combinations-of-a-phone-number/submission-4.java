class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() < 1) return res;
        String[] lookups = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        helper(digits, 0, lookups, new Stack<Character>());
        return res;
    }

    public void helper(String s, int i, String[] lookups, Stack<Character> set){
        if(i >= s.length()){
            res.add(stackToString(set));
            return;
        }

        String targets = lookups[s.charAt(i) - '0'];
        for(char c : targets.toCharArray()){
            set.push(c);
            helper(s, i+1, lookups, set);
            set.pop();
        }
    }

    private String stackToString(Stack<Character> stack){
        String s = "";
        for(char c: stack) s+= c;
        return s;
    }
}
