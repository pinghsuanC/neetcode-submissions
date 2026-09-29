class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, max = nums[0];

        for(int n : nums){
            // at each position, either
            // 1) start a new array
            // 2) continue the previous array
            curSum = Math.max(curSum + n, n);
            max = Math.max(max, Math.max(curSum, n));
        }

        return max;
    }
}
