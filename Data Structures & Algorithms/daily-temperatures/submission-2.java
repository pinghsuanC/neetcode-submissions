class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack =  new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.empty() && stack.peek()[1] < t){
                int[] pair = stack.pop();
                res[pair[0]] = i - pair[0];
            }

            stack.push(new int[]{i, t});
        }
        return res;
    }
}
