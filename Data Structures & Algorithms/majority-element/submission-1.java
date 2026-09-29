class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1, target = nums.length / 2, res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                count++;
                if(count > target) res = nums[i];
                continue;
            } else {
                count = 1;
            }
        }
        return res;
    }
}