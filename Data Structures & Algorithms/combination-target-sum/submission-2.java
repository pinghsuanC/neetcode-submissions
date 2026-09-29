class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<List<Integer>>();
        helper(nums, 0, target, new ArrayList<>());
        return res;
    }

    public void helper(int [] nums, int i, int target, ArrayList<Integer> set){
        if(target == 0 ){
            res.add(new ArrayList<>(set));
            return;
        }

        if(target < nums[i]){
            return;
        }

        for(int k = i; k < nums.length; k++){
            set.add(nums[k]);
            helper(nums, k, target-nums[k], set);
            set.remove(set.size() - 1);
        }
    }
}
