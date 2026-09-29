class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;

        int l = 0, r = x;
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;
            long res = (long)mid * mid;
            if(res == x) return mid;
            if(res < x){
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }

        }
        return ans;
    }
}