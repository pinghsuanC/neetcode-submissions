class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int minK = piles[piles.length - 1];
        int l = 1,  r = minK;
        int res = r;
        while(l <= r){
            int m = l + (r - l) / 2;
            int hrs = helperHours(piles, m);
            if(hrs <= h){
                // Try to find smaller k
                r = m - 1;
                res = m;
            } else {
                // move l pointer to right, you need faster
                l = m + 1;
            }
        }

        return res;
    }

    public int helperHours(int[] piles, int k){
        int h = 0;
        for(int p : piles){
            h += (p / k);
            if(p % k > 0) {
                h++;
            }
        }
        return h;
    }
}
