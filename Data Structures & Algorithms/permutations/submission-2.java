class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new boolean[nums.length], new ArrayList<>(Collections.nCopies(nums.length, -100)));
        return res;
    }

    public void helper(int[] nums, int i, boolean[] skips, List<Integer> set){
        if(i >= nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(true == skips[j]) continue;
            set.set(j, nums[i]);
            skips[j] = true;
            helper(nums, i+1, skips, set);
            set.set(j, -100);
            skips[j] = false;

        }

    }
}
