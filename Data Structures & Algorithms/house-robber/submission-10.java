class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n + 2];

        int oneBefore = 0, twoBefore = 0;
        for(int i = n - 1; i >=0; i--){
            int cur = Math.max(oneBefore, twoBefore + nums[i]);
            twoBefore = oneBefore;
            oneBefore = cur;
        }

        return oneBefore;
    }
}
