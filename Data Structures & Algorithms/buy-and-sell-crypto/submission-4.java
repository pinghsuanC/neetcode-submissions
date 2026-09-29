class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = prices.length - 1;
        int res = 0;
        int[] maxRight = new int[prices.length];
        int[] minLeft = new int[prices.length];
        int[] maxp = new int[prices.length];

        int max = 0;
        int maxProfit = 0;
        for(int i =prices.length-1; i >= 0; i--){
            maxRight[i] = max;
            int tmp = maxRight[i] - prices[i];
            maxProfit = Math.max(tmp, maxProfit);
            if(prices[i] > max){
                max = prices[i];
            }
        }
        
        return maxProfit;
    }
}
