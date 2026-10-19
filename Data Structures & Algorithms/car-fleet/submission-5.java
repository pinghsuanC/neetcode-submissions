class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        ArrayList<int[]> arr = new ArrayList<>();
        int n = position.length;

        for(int i = 0; i < n; i++) arr.add(new int[]{position[i], speed[i]});
        Collections.sort(arr, (a, b) -> b[0] - a[0]);

        for(int[] car : arr){
            // t -> the time the car needs to reach the target
            double t = (double) (target - car[0]) / car[1];
            if(stack.isEmpty()){
                stack.push(t);
                continue;
            }

            // need to check if fleets with the previous car
            if(t > stack.peek()) {
                stack.push(t);
            }
        }

        return stack.size();
    }
}
