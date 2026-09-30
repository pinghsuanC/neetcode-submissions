class Solution {
    Integer[][] tabula;
    public boolean stoneGame(int[] piles) {
        tabula = new Integer[piles.length][piles.length];
        return helper(piles, 0, piles.length - 1) > 0;
    }

    public int helper(int[] piles, int left, int right){
        if(left == right) return 0;
        if(tabula[left][right] != null) return tabula[left][right];


        int takeLeft = piles[left] - helper(piles, left+1, right);
        int takeRight = piles[right] - helper(piles, left, right-1);
        tabula[left][right] = Math.max(takeLeft, takeRight);
        return tabula[left][right];
    }
}