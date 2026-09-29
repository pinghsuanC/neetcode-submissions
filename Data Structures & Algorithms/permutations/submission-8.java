class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], 0, new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, boolean[] used, int i, ArrayList<Integer> set){
        if(i == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        for(int k = 0; k < nums.length; k++){
            if(used[k] == true) continue;
            used[k] = true;
            set.add(nums[k]);
            helper(nums, used, i+1, set);
            set.remove(set.size() - 1);
            used[k] = false;
        }
    }
}
