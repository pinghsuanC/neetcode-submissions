class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            while(!stack.empty() && stack.peek()[1] < temp){
                int[] pair = stack.pop();
                result[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, temp});
        }
        return result;
    }
}
