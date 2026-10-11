class Solution {
    public int splitArray(int[] nums, int k) {
        /*
        -> binary search + greedy method

        */

        int n = nums.length, sum = 0;
        int l = Integer.MIN_VALUE, r = 0;
        for(int i = 0; i < nums.length; i++){
            l = Math.max(l, nums[i]);
            r+=nums[i];
        }

        // l = minimun you have to have the subarray
        // r = if we only have 1 huge sub array
        int min = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(canSplit(nums, k, mid)){
                // means we can try to make the celling smaller
                r = mid - 1;
                min = Math.min(mid, min);
            } else {
                // means we can make the floor higher
                l = mid + 1;
            }
        }

        return min;
    }


    private boolean canSplit(int[] nums, int k, int max){
        int groups = 0, curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum+=nums[i];
            if(curSum > max){
                groups++;
                if(groups == k) return false;
                curSum = nums[i];
            }
        }

        return true;
    }
    
}