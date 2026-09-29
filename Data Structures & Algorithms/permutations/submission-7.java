class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, boolean[] used, ArrayList<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == true) continue;
            used[i] = true;
            set.add(nums[i]);
            helper(nums, used, set);
            used[i] = false;
            set.remove(set.size() - 1);
        }
    }
}
