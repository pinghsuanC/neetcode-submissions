class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;

        for(int n : nums){
            sum = Math.max(n, n + sum);
            max = Math.max(max, sum);
        }

        return max;
    }
}
