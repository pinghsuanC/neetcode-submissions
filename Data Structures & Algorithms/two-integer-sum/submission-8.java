class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            indexMap.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int targetJ = target - nums[i];
            if(indexMap.get(targetJ) != null && i != indexMap.get(targetJ) ){
                return new int[]{i, indexMap.get(targetJ)};
            }
        }
        return new int[0];
    }
}
