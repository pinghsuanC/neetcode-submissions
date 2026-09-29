class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> set){
        res.add(new ArrayList<>(set));

        for(int j = i; j < nums.length; j++){
            set.add(nums[j]);
            helper(nums, j+1, set);
            set.remove(set.size() - 1);
        }
    }
}
