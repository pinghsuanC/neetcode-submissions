class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        back(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    public void back(int[] nums, int i, int target, ArrayList<Integer> set, ArrayList<List<Integer>> res){
        if(i >= nums.length || target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        back(nums, i, target - nums[i], set, res);
        set.remove(set.size() - 1);
        back(nums, i+1, target, set, res);
    }
}
