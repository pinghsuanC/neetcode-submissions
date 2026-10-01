class Solution {
    public int shipWithinDays(int[] weights, int days) {
        /*
        intuition:
        -> order is given and can't change
        -> not allowed to load weight more than max weight capacity
            -> bottleneck: max weight of all weights            
        -> find Return the least weight capacity so we can done the weights in days day
        */

        int maxWeight = Arrays.stream(weights).max().getAsInt();
        int total = Arrays.stream(weights).sum();

        int l = maxWeight, r = total;
        int res = r;
        while(l <= r){
            int m = (r + l) / 2;
            if(canShip(weights, days, m)) {
                res = Math.min(res, m);
                r = m - 1;
                continue;
            } else {
                l = m + 1;
            }
        }

        return res;
    }


    private boolean canShip(int[] weights, int days, int cap){
        int ships = 1, curCap = cap;
        for(int w : weights){
            if(curCap - w < 0){
                ships++;
                if(ships > days) return false;
                curCap = cap;
            }
            curCap -= w;
        }
        return true;
    }
}