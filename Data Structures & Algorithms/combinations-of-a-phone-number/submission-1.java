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

        int k = 0;
        int upper = 3;
        if(s.charAt(i) == '7' || s.charAt(i) == '9'){
            upper = 4;
        }

        for(; k < upper; k++){
            int val = Character.getNumericValue(s.charAt(i));
            char tar = (char)('a' + (val - 2) * 3 + k);
            if(s.charAt(i) > '7'){
                tar = (char)('a' + (val - 2) * 3 + k + 1);
            }
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
