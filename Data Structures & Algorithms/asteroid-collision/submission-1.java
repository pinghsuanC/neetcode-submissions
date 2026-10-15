class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
        Stack to stack the astroids
        */

        Stack<Integer> stack = new Stack<>();
        for(int n : asteroids){
            while(!stack.isEmpty() && n < 0 && stack.peek() > 0){
                int diff = n + stack.peek();
                if(diff < 0){
                    stack.pop();
                } else if (diff > 0){
                    n = 0;
                } else {
                    n = 0;
                    stack.pop();
                }
            }
            if(n == 0) continue;
            stack.add(n);
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            res[i] = stack.pop();
            i--;
        }

        return res;
    }
}