class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int res = nums[0];
        
        for(int n : nums){
            int tmp = n * max;
            max = Math.max(n * min, Math.max(n, n * max));
            min = Math.min(tmp, Math.min(n, n*min));
            res = Math.max(max, res);
        }

        return res;
    }
}
