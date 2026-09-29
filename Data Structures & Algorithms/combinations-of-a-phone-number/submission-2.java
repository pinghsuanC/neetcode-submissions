class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() < 1) return res;
        helper(digits, 0, new Stack<Character>());
        return res;
    }

    public void helper(String s, int i, Stack<Character> set){
        if(i >= s.length()){
            res.add(stackToString(set));
            return;
        }

        int upper = 3;
        if(s.charAt(i) == '7' || s.charAt(i) == '9')  upper = 4;
        for(int k = 0; k < upper; k++){
            char tar = (char)('a' + (s.charAt(i) - '0' - 2) * 3 + k);
            if(s.charAt(i) > '7') tar++;
            set.push(tar);
            helper(s, i+1, set);
            set.pop();
        }
    }

    private String stackToString(Stack<Character> stack){
        String s = "";
        for(char c: stack) s+= c;
        return s;
    }
}
