class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int curSum = numbers[i] + numbers[j];
            if(curSum > target){
                j--;
            } else if(curSum < target){
                i++;
            } else {
                return new int[]{i+1, j+1}; 
            }
        }
        return new int[]{i+1, j+1};
    }
}
