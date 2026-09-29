class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        back(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    public void back(int[] nums, boolean[] used, List<Integer> perm){
        if(perm.size() == nums.length){
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int j = 0; j < nums.length; j++){
            if(used[j] == true) continue;
            
            perm.add(nums[j]);
            used[j] = true;
            back(nums, used, perm);
            perm.remove(perm.size() - 1);
            used[j] = false;
        }
    }
}
