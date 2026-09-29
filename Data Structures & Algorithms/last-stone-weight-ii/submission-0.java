class Solution {

    int[][] memo;

    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;
        
        memo = new int[stones.length][target+1];
        for(int[] k : memo) Arrays.fill(k, -1);

        int best = helper(stones, 0, 0, target);

        return total - 2 * best;
    }

    private int helper(int[] stones, int i, int sum, int target) {
        if (i == stones.length) return sum;
        if (memo[i][sum] != -1) return memo[i][sum];

        int skip = helper(stones, i + 1, sum, target);

        int take = 0;
        if (sum + stones[i] <= target) {
            take = helper(stones, i + 1, sum + stones[i], target);
        }

        return memo[i][sum] = Math.max(skip, take);
    }


}