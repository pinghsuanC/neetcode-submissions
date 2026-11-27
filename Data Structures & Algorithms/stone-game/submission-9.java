class Solution {
    Integer[][] tabula;
    public boolean stoneGame(int[] piles) {
        /*
        intuition:
        still remember the answer "return true" cause' alice is always going to win if played optimally lol

        even number of piles
        want to end with the most stones
        total number of stones is odd
        alice starting first, each taking beginning or end of the row

        */


        tabula = new Integer[piles.length][piles.length];
        return helper(piles, 0, piles.length - 1) > 0;
    }


    private int helper(int[] piles, int left, int right){
        if(left == right) return 0;
        if(tabula[left][right] != null) return tabula[left][right];

        int takeLeft = piles[left] - helper(piles, left+1, right);
        int takeRight = piles[right] - helper(piles, left, right-1);
        
        tabula[left][right] = Math.max(takeLeft, takeRight);
        return tabula[left][right];
    }
}