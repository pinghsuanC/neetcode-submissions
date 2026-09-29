class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        // Intuition: backtracking
        // each permutation is built on a path of the tree
        // traverse through the decisions until the options are exhausted
        // base case would be the length of current subset

        // use a memory to store what elements are taken. we need to start with 0 index every time.

        res = new ArrayList<>();
        back(nums, 0, new boolean[nums.length],new ArrayList<>());
        return res;
    }

    private void back(int[] nums, int i, boolean[] taken, List<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(taken[j]) continue;
            set.add(nums[j]);
            taken[j] = true;
            back(nums, j, taken, set);
            set.remove(set.size() - 1);
            taken[j] = false;
        }
    }
}
