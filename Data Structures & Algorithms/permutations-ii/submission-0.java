class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, boolean[] taken, List<Integer> perm){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(j > 0 && nums[j] == nums[j-1] && !taken[j-1]) continue;
            if(taken[j]) continue;
            perm.add(nums[j]);
            taken[j] = true;
            helper(nums, j+1, taken, perm);
            perm.remove(perm.size() - 1);
            taken[j] = false;
        }
    }
}