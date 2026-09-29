class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        back(nums, 0, new ArrayList<>());
        return res;
    }

    public void back(int[] nums, int i, List<Integer> perm){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int j = i; j < nums.length; j++){
            perm.add(nums[j]);
            swap(nums, i, j);
            back(nums, i+1, perm);
            perm.remove(perm.size() - 1);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
