class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return false;

        int l = 0, r = n-1;
        while(r > 0){
            for(int i = 0; i < r; i++){
                if(nums[i] == nums[r] && Math.abs(i - r) <= k) return true;
            }
            r--;
        }


        return false;
    }
}