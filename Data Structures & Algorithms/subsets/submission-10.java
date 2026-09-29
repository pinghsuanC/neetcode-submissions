class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> set){
        res.add(new ArrayList<Integer>(set));

        for(int k = i; k < nums.length; k++){
            set.add(nums[k]);
            helper(nums, k+1, set);
            set.remove(set.size() - 1);
        }
    }
}
