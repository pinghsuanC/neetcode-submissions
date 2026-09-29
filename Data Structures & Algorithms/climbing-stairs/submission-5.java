class Solution {
    int[] memo;
    public int climbStairs(int n) {
        if(n <= 2) return n;
        memo = new int[n + 1];
        for(int i= 0; i < n+1; i++){
            memo[i] = -1;
        }
        helper(n);
        return memo[n];
    }

    private int helper(int n){
        if(n <= 2) return n;

        if(memo[n] != -1) return memo[n];

        memo[n] = helper(n - 1) + helper(n - 2);
        return memo[n];
    }
}
