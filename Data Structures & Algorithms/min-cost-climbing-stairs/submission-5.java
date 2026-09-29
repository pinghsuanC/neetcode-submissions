class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
        intuition: after paying for the step i, you can either choose i + 1 or i + 2
        from the destination n we know for sure we will step onto, we can unfold it backwards

        let dp[i] = the min cost it takes from i to n
        */

        for(int i = cost.length - 3; i >=0; i--){
            cost[i] = cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
