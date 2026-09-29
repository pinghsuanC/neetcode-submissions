class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0);
        res.add(new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, ArrayList<List<Integer>> res, int i){
        if(i==nums.length){
            return;
        }

        helper(nums, res, i+1);
        List<List<Integer>> subsets = new ArrayList<>();
        for(List<Integer> s : res) {
            ArrayList<Integer> copy = new ArrayList<>(s);
            copy.add(nums[i]);
            subsets.add(copy);
        }
        List<Integer> k = new ArrayList<>();
        k.add(nums[i]);
        res.add(k);
        res.addAll(subsets);
    }
}
