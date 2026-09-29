class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> set){
        res.add(new ArrayList<>(set));

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]) continue;
            set.add(nums[j]);
            helper(nums, j+1, set);
            set.remove(set.size() - 1);
        }

    }
}
