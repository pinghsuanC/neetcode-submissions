class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int l = 0, r = 1;
        int maxP = 0;

        while(r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
                r++;
                continue;
            } else{
                maxP = Math.max(maxP, (prices[r] - prices[l]));
                r++;
            }
        }

        return maxP;
    }
}
