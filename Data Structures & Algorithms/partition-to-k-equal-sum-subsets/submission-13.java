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


        return helper(nums, k, 1, taken, 0);
    }

    private boolean helper(int[] nums, int k, int bags, boolean[] taken, int acc){
        if(k == bags) return true;

        for(int j = 0; j < nums.length; j++){
            if(taken[j]) continue;
            int newValue = acc + nums[j];
            if(newValue > TARGET) return false;
            
            if(newValue == TARGET){
                taken[j] = true;
                if(helper(nums, k, bags+1, taken, 0)) return true;
                taken[j] = false;
            } else {
                taken[j] = true;
                if(helper(nums, k, bags, taken, newValue)) return true;
                taken[j] = false;
            }
        }

        return false;
    }
}