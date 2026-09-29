class Solution {
    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        memo1 = new int[nums.length];
        memo2 = new int[nums.length];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        
       return Math.max(helper(nums, 0, n-2, memo1), helper(nums, 1, n-1, memo2));
    }

    public int helper(int[] nums, int start, int end, int[] memo){
        if(start > end) return 0;
        if(memo[start] >= 0) return memo[start];

        memo[start] = Math.max(helper(nums, start+1, end, memo), nums[start] + helper(nums, start+2, end, memo));
    
        return memo[start];
    }

}
