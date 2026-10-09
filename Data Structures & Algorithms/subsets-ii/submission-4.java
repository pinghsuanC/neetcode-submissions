class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();

        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> set){
        if(i > nums.length) return;

        res.add(new ArrayList<>(set));


        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]) continue;
            set.add(nums[j]);
            helper(nums, j+1, set);
            set.remove(set.size() - 1);
        }
    }
}
