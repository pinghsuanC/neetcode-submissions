class Solution {
    int[][] memo;
    public int lastStoneWeightII(int[] stones) {
        int total = Arrays.stream(stones).sum();
        int target = total / 2;
        
        
        memo = new int[stones.length][target+1];
        for(int[] m : memo) Arrays.fill(m, -1);

        int best = helper(stones, target, 0, 0);

        return total - best * 2;
    }

    public int helper(int[] stones, int target, int i, int acc){
        if(i >= stones.length) return acc;
        if(memo[i][acc] >= 0) return memo[i][acc];
        
        // skip
        int skip = helper(stones, target, i+1, acc);

        // take the stone
        int take = 0;
        if(acc + stones[i] <= target){
            take = helper(stones, target, i+1, acc+stones[i]);
        }

        memo[i][acc] = Math.max(skip, take);
        return memo[i][acc];
    }
}