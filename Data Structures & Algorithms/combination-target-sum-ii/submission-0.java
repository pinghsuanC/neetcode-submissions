class Solution {

    ArrayList<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, int target, List<Integer> set){
        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }
        if(i >= nums.length || target < 0) return;

        for(int j = i; j < nums.length; j++){
            // remove duplicates by removing deplicates
            if(j > i && nums[j] == nums[j - 1]) continue;
            if(target < nums[j]) return;
            set.add(nums[j]);
            helper(nums, j + 1, target - nums[j], set);
            set.remove(set.size() - 1);
        }
    }
}
