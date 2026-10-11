class Solution {
    public int shipWithinDays(int[] weights, int days) {
        /*
        -> binary search + greedy
        
        key: 
        lower bound = the maximun of the packages (you can't split the package)
        uppwer bound = let's start with total weights
        binary search to find the lowerst weight you can go to ship within days days
        */

        int n = weights.length;
        int l = Integer.MIN_VALUE, r = 0;
        for(int w : weights){
            l = Math.max(l, w);
            r+=w;
        }

        int min = Integer.MAX_VALUE;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(canShip(weights, days, m)){
                // try to lower the ceiling
                r = m - 1;
                min = Math.min(m, min);
            } else {
                // try to higher the flower
                l = m + 1;
            }
        }
        return min;
    }


    public boolean canShip(int[] weights, int days, int max){
        int k = 0, curSum = 0;
        for(int w : weights){
            curSum += w;
            if(curSum > max) {
                k++;
                if(k == days) return false;
                curSum = w;
            }
        }
        return true;
    }
}