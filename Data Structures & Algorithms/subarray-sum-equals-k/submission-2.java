class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
        intuition: given prefix solution, use hashmap to record the prefix[j]
        prefix[i] = prefix[j] - k


        */

        int count = 0, n = nums.length, curSum = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        for(int num : nums){
            curSum += num;
            int diff = curSum - k;
            count += prefix.getOrDefault(diff, 0);
            prefix.put(curSum, prefix.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}