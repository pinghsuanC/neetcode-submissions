class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            for(int s = 1; s*s <= i; s++){
                dp[i] = Math.min(dp[i], 1 + dp[i - s*s]);
            }
        }


        return dp[n];
    }
}