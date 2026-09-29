class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, max = 0;
        for(int r = 0; r < prices.length; r++){
            max = Math.max(max, prices[r] - prices[l]);
            if(prices[r] < prices[l]){
                l = r;
            }
        }
        return max;
    }
}
