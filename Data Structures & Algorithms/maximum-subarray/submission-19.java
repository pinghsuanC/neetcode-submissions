class Solution {
    public int maxSubArray(int[] nums) {
        /*
        intuition
        Greedy always confuses me... :'D
        There is no intuitive reasoning, only mathmatically prove that a specific set up could work...

        need the largest sum of subarray
        subarray = contiguous non-empty sequence of elements (minLen = 1)

        at each position i
            -> if curSum < 0, set curSum to 0 (a negative value will always result in a smaller sum) 
            -> update curSum with nums[i]
            max = Max of (current Max, or the new sum of subarray curSum)
        */

        int curSum = 0, curMax = nums[0];
        for(int n : nums){
            if(curSum < 0) curSum = 0;
            curSum+=n;
            curMax = Math.max(curMax, curSum);
        }
        

        return curMax;
    }
}
