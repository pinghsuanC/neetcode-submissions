class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, int target, int i, ArrayList<Integer> set){
        if(target == 0) {
            res.add(new ArrayList<>(set));
            return;
        }
        if(i >= nums.length) return;
        if(target < nums[i]) return;

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]) continue;
            set.add(nums[j]);
            helper(nums, target-nums[j], j+1, set);
            set.remove(set.size() - 1);
        }
    }
}
