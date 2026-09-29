class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i<position.length; i++){
            arr.add(new int[]{position[i], speed[i]});
        }
        arr.sort((a, b) -> b[0] - a[0]);
        System.out.println(Arrays.toString(arr.get(0)));

        Stack<Double> stack = new Stack<>();
        for(int[] info : arr){
            double pre = -1.0;
            if(!stack.empty()){
                pre = stack.peek();
            }
            double t = ((double) (target - info[0])) / info[1];
            stack.push(t);
            if(pre > 0 && t <= pre){
                stack.pop();
            }

        }

        return stack.size();
    }
}
