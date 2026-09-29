class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums, boolean[] used, List<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }
        
        for(int j = 0; j < nums.length; j++){
            if(true == used[j]) continue;
            set.add(nums[j]);
            used[j] = true;

            helper(nums, used, set);

            used[j] = false;
            set.remove(set.size() - 1);
        }
    }
}
