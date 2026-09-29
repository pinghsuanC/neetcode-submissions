class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i){
        if(i == nums.length){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int n : nums) arr.add(n);
            res.add(arr);
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[i]) continue;
            swap(nums, i, j);
            helper(nums, i+1);
        }

        for (int j = nums.length - 1; j > i; j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}