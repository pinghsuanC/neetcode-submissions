class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length && nums[k] <= 0; k++){
            if(k > 0 && k < nums.length && nums[k] == nums[k - 1]) continue;
            int target = 0 - nums[k];
            int l = k + 1, r = nums.length - 1;
            while(l < r){
                int v = nums[l] + nums[r];
                if(v > target){
                    r--;
                } else if (v < target){
                    l++;
                } else {
                    List<Integer> set = new ArrayList<>();
                    set.add(nums[k]);
                    set.add(nums[l]);
                    set.add(nums[r]);
                    res.add(set);
                    // move pointer
                    l++;
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
