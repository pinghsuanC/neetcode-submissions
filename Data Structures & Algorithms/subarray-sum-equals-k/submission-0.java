class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
        intuition: 2 pointers? prefixsum?

        1. get the prefix sum
        2. for i from 0 to n
            for j < n
                calculate the array sum by j - i
                if sum = k, count++

        3. return count
        */

        int count = 0, n = nums.length;
        int[] prefix = new int[n+1];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=nums[i];
            prefix[i+1] = sum;
        }

        for(int i = 0; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                if(prefix[j] - prefix[i] == k) count++;
            }
        }

        return count;
    }
}