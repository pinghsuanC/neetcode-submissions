class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int k = 0; k<nums.length; k++){
            if(nums[k] > 0){ break; }
            int l = k + 1;
            int r = nums.length-1;
            int target = 0 - nums[k];
            if(k > 0 && nums[k] == nums[k - 1]){ continue; }
            while(l < r){
                int sum = nums[r] + nums[l];
                if(sum < target){
                    l++;
                } else if(sum > target){
                    r--;
                } else {
                    List<Integer> tmp = new ArrayList<Integer>(3);
                    tmp.add(nums[k]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }
        }
        return res;

    }
}
