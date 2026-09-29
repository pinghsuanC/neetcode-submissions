class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){ break; }
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            int target = 0 - nums[i];
            while(l < nums.length && l < r){
                int val = nums[l] + nums[r];
                if(val < target){
                    l++;
                }else if(val > target){
                    r--;
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    // move pointers
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
