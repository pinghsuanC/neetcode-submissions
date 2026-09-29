class Solution {
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        helper(nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, int i, List<Integer> subset){
        int xorr = 0;
        for(int n : subset){
            xorr^=n;
        }
        res+=xorr;

        for(int j = i; j < nums.length; j++){
            subset.add(nums[j]);
            helper(nums, j+1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}