class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        res.add(new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, List<List<Integer>> res){
        if(i == nums.length) return;
        List<List<Integer>> tmp = new ArrayList<>();
        helper(nums, i+1, res);
        for(List<Integer> r : res){
            List<Integer> subset = new ArrayList<>(r);
            subset.add(nums[i]);
            tmp.add(subset);
        }
        res.addAll(tmp);
        List<Integer> set = new ArrayList<>(Arrays.asList(nums[i]));
        res.add(set);
    }

}
