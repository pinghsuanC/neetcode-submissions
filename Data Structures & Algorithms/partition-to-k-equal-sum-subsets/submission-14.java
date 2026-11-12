class Solution {
    /*
    intuition:
    need all sum equal = x
    x*k = total

    check if it's possible first, and then try to partition into bags of value = x
    
    */

    int TARGET = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if(total % k != 0) return false;

        Arrays.sort(nums);
        TARGET = total / k;

        boolean[] taken = new boolean[nums.length];


        return helper(nums, k, taken, 0, 0);
    }

    private boolean helper(int[] nums, int k, boolean[] taken, int acc, int i){
        if(k == 0) return true;

        for(int j = i; j < nums.length; j++){
            if(taken[j]) continue;
            int newSum = acc + nums[j];
            if(newSum > TARGET) return false;
            
            if(newSum == TARGET){
                taken[j] = true;
                if(helper(nums, k-1, taken, 0, 0)) return true;
                taken[j] = false;
            } else {
                taken[j] = true;
                if(helper(nums, k, taken, newSum, j+1)) return true;
                taken[j] = false;
            }
        }

        return false;
    }
}