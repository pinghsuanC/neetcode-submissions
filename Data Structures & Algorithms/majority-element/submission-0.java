class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int res = nums[0];
        for(int n : nums){
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
            if(map.get(n) > (len / 2)) {
                res = n;
                return n;
            }
        }
        return res;
    }
}