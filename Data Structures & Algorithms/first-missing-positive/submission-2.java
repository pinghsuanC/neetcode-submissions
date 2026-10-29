class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
        intuition: 
        get the largest positive integer
        and cascadingly search for the smaller one

        if reached 0, we don't have any in range smaller than max, it has to be largest positive integer + 1
        
        */


        int n = nums.length;
        Map<Integer, Boolean> map = new HashMap<>();
        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

        int max = 0, min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= 0) continue;
            map.put(num, true);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        if(min > 1) return 1; // floor

        int res = MAX - 1;
        for(int num : nums){
            if(num <= 0) continue;
            if(num == MAX) continue;
            if(map.containsKey(num+1)) continue;
            res = Math.min(num+1, res);
        }

        return res;
    }
}