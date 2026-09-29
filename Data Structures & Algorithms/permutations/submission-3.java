class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i){
        if(i == nums.length){
            List<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
            res.add(set);
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            helper(nums, i+1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
