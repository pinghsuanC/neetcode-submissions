class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // backgtracking
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        helper(nums, i+1, subset, res);
        subset.remove(subset.size() - 1);
        helper(nums, i+1, subset, res);
    }
}
