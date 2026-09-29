class Solution {
    public int climbStairs(int n) {
        if(n < 2) return n;

        int[] dp = new int[n+1];
        int two_steps_before = 1;
        int one_step_before = 2;

        for(int i = 3; i <= n; i++){
            int cur = two_steps_before + one_step_before;
            two_steps_before = one_step_before;
            one_step_before = cur;
        }
        return one_step_before;
    }
}
