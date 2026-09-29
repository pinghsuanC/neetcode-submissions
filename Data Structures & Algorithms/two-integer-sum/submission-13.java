class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            int targetJ = target - nums[i];
            if(mp.get(targetJ) != null){
                return new int[]{mp.get(targetJ), i};
            } else {
                mp.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
