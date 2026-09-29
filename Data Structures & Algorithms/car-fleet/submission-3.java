class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<int[]> stack = new Stack<>();
        ArrayList<int[]> cars = new ArrayList<>();
        for(int i = 0; i < position.length; i++){
            cars.add(new int[]{position[i], speed[i]});
        }
        cars.sort((car1, car2) -> car2[0] - car1[0]);

        for(int i = 0; i<cars.size(); i++){
            if(stack.empty()){
                stack.push(cars.get(i));
                continue;
            }

            int[] pre = stack.peek();
            int[] cur = cars.get(i);
            double preT = (double)(target - pre[0]) / pre[1];
            double curT = (double)(target - cur[0]) / cur[1];
            if(preT >= curT){ // collide happened
                continue;
            } else {
                // no collide happened
                stack.push(cur);
            }
        }
        return stack.size();
    }
}
