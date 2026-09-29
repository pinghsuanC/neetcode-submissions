class Solution {

    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length() + 1][s.length() + 1];
        
        return helper(s, 0, 0);
    }

    public boolean helper(String s, int i, int open){
        if(open < 0) return false;
        if(i >= s.length()) return open == 0;
        if(dp[i][open] != null) return dp[i][open];

        boolean res;
        if(s.charAt(i) == '(') {
            res = helper(s, i+1, open + 1);
        } else if(s.charAt(i) == ')'){
            res = helper(s, i+1, open - 1);
        } else{
            res = helper(s, i+1, open +1) || helper(s, i+1, open - 1) || helper(s, i+1, open);
        }

        dp[i][open] = res;
        return dp[i][open];
    }
}
