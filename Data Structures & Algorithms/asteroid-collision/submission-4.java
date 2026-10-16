class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids){
            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                int diff = stack.peek() + a;
                if(diff < 0){
                    stack.pop();
                } else if (diff == 0) {
                    // both destroyed
                    stack.pop();
                    a = 0;
                } else {
                    // a destroyed
                    a = 0;
                }
            }
            if(a == 0) continue;
            stack.push(a);
        }

        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            res[i] = stack.pop();
        }

        return res;
    }
}