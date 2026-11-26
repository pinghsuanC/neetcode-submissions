class Solution {
    int[][] tab;
    public int change(int amount, int[] coins) {
        /*
        intuition: backtrakcing? DP?
        want: # distinct combinations that total up to amount, 0 if not possible

        */
        tab = new int[coins.length][amount+1];
        for(int[] t : tab) Arrays.fill(t, -1);
    
        Arrays.sort(coins);

        return helper(coins, amount, 0);
    }

    private int helper(int[] coins, int target, int i){
        if(target == 0) return 1; // reached the base case 
        if(i >= coins.length) return 0; // not possible
        if(tab[i][target] >= 0) return tab[i][target];

        // at position i, you can either 1) take ith coin (note you can take infinite) 2) don't take the ith coin
        // if the target < coin value, then it's not a valid path
        if(target < coins[i]) return 0;

        int take = helper(coins, target-coins[i], i);
        int skip = helper(coins, target, i+1);
        tab[i][target] = take + skip;
        
        return take + skip;
    }

}
