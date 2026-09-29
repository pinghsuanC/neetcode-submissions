class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = prices.length - 1;
        int res = 0;
        int[] maxRight = new int[prices.length];
        int[] minLeft = new int[prices.length];
        int[] maxp = new int[prices.length];

        for(int i =0; i<prices.length; i++){
            long max = Long.MIN_VALUE;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] > max){
                    max = prices[j];
                }
            }
            maxRight[i] = (int)max;
        }

        int maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            int tmp = maxRight[i] - prices[i];
            maxProfit = tmp > maxProfit ? tmp : maxProfit;
        }

        return maxProfit;
    }
}
