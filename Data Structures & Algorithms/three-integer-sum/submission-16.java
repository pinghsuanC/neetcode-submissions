class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length; k++){
            // handle duplicates
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int target = 0 - nums[k];
            int l = k + 1, r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] < target){
                    l++;
                } else if(nums[l] + nums[r] > target){
                    r--;
                } else {
                    // got a hit
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    l++;
                    r--;
                    // handle duplicates by moving l pointer
                    while(l > 0 && l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }
        return res;
    }
}
