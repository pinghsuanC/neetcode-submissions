class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        res = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<Integer>());

        return res;
    }

    private void helper(int[] nums, int i, int target, ArrayList<Integer> list){
        if(i >= nums.length) return;
        if(target < 0) return;

        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(j > 1 && nums[j] == nums[j - 1]) continue;
            
            list.add(nums[j]);
            helper(nums, j, target - nums[j], list);
            list.remove(list.size() - 1);
        }
    }
}
