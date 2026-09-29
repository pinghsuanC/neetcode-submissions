class Solution:
    
    def rob(self, nums: List[int]) -> int:
        memo = [-1] * len(nums);

        def helper(nums: List[int], i: int) -> int:
            if i >= len(nums):
                return 0;
            if memo[i] >= 0: return memo[i];

            memo[i] = max(nums[i] + helper(nums, i+2), helper(nums, i+1));
            return memo[i];
        
        return helper(nums, 0);
        