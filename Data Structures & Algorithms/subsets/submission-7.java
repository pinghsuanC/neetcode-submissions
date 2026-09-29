class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> set){
        if(i == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        helper(nums, i+1, set);
        set.add(nums[i]);
        helper(nums, i+1, set);
        set.remove(set.size() - 1);
    }
}
