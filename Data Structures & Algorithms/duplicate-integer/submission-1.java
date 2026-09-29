class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(counts.get(nums[i]) == null){
                counts.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }
}