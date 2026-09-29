class Solution {
    ArrayList<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(nums.length - 1), new ArrayList<>(Collections.nCopies(nums.length, -100)));
        return res;
    }

    public void helper(int[] nums, int i, List<Integer> skips, List<Integer> set){
        if(skips.size() >= nums.length) {
            res.add(new ArrayList<>(set));
            return;
        }
        if(i >= nums.length) return;

        for(int j = 0; j < nums.length; j++){
            if(skips.contains(j)) continue;
            set.set(j, nums[i]);
            skips.add(j);
            helper(nums, i+1, skips, set);
            set.set(j, -100);
            skips.remove(skips.size() - 1);

        }

    }
}
