class Solution {
    int[][] tab;
    public int change(int amount, int[] coins) {
        /*
        Intuition:
        arr of coints, amount = target
        need: # distinct ways to make up amount
        # of coin is unlimited for each value

        dfs for each coin selection
        tabulate the state 

        */

        tab = new int[coins.length][amount + 1];
        for(int[] arr : tab) Arrays.fill(arr, -1);

        Arrays.sort(coins);
        return helper(coins, amount, 0);
    }


    public int helper(int[] coins, int target, int i){
        if(target == 0) return 1;
        if(i >= coins.length) return 0;
        if(tab[i][target] > 0) return tab[i][target];

        int res = 0;
        if(coins[i] > target) return res;

        // don't take i at all
        res = helper(coins, target, i+1);
        // take 1 i
        res += helper(coins, target-coins[i], i);

        tab[i][target] = res;

        return res;
    }
}







