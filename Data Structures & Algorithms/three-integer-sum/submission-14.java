class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int total = nums[l] + nums[r];
                if(total < target){
                    l++;
                } else if(total > target){
                    r--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    // move pointers + move l to remove dups
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
