class Solution {
     public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;

        while(r < nums.length - 1){
            int farthest = 0;
            for(int i = 0; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }

            r = farthest;
            res++;
        }

        return res;
    }
}
