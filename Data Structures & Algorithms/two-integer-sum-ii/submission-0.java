class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 1;
        int j = numbers.length;
        while(i < j){
            if(numbers[i-1] + numbers[j-1] == target){ 
                break;
            }
            int targetI = target - numbers[j-1];
            int targetJ = target - numbers[i-1];
            if(targetI > numbers[i-1]){
                i++;
                continue;
            }
            
            if(targetJ < numbers[j-1]){
                j--;
                continue;
            }
        }
        return new int[]{i, j};
    }
}
