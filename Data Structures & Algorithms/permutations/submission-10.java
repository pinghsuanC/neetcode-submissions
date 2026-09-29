class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        helper(nums, taken, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, boolean[] taken, ArrayList<Integer> set){
        if(set.size() == nums.length){
            System.out.println(set);
            res.add(new ArrayList<>(set));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(taken[j]) continue;
            set.add(nums[j]);
            taken[j] = true;
            helper(nums, taken, set);
            set.remove(set.size() - 1);
            taken[j] = false;
        }
        
    }
}
