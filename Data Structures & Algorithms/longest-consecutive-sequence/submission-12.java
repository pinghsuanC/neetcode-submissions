class Solution {
    public int longestConsecutive(int[] nums) {
        int k = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, map.getOrDefault(n - 1, 0) + map.getOrDefault(n+1, 0) + 1);
                map.put(n - map.getOrDefault(n - 1, 0), map.get(n));
                map.put(n + map.getOrDefault(n + 1, 0), map.get(n));
                max = Math.max(max, map.get(n));
            }
        }
        return max;
    }
}
