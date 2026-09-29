class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // intuition: 
        // backtracking
        // skip the duplicated possible steps
        // since at each level we are exhauting all the possibilities, 
        // we can skip safely until the possible route is not duplicated
        Arrays.sort(nums);
        res = new ArrayList<>();
        back(nums, 0, new ArrayList<>());
        return res;
    }

    private void back(int[] nums, int i, ArrayList<Integer> set){
    
        res.add(new ArrayList<>(set));

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]) continue;
            set.add(nums[j]);
            back(nums, j+1, set);
            set.remove(set.size() - 1);
            
        }
    }

}
