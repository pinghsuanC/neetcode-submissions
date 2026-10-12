class Solution {
    public int splitArray(int[] nums, int k) {
        /*
        similar to the cargo issue

        1. find a minimun, which is the largest in nums
        2. find a maximun, which is the sum of nums (i.e. just take the entire thing)
        3. find the mid.
            -> if mid is able to split nums into k, means we can shrink the upper bound
            -> if not able to split into k, means we have to increase the lower bound
            -> do this until bounds converge
        
        */
        int l = Integer.MIN_VALUE, r = 0;
        for(int n : nums){
            l = Math.max(l, n);
            r+=n;
        }

        int min = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canSplit(nums, k, mid)){
                r=mid-1;
                min = Math.min(min, mid);
            } else {
                l=mid+1;
            }
        }

        return min;
    }


    private boolean canSplit(int[] arr, int k, int load){
        int curK = 0, curSum = 0;
        for(int n : arr){
            curSum+=n;
            if(curSum > load) {
                curK++;
                if(curK == k) return false;
                curSum = n;
            }
        }
        return true;
    }
}