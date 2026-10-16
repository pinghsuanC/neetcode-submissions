class StockSpanner {

    /*
    Use a stack to track price + span
    -> when pushing a new price into the stack, check the previous number
        -> if previous number is larger, span = 0, no need to accumulate
        -> if previous number is same or smaller, span = previous span + 1

    */

    Stack<int[]> stack;
    // [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty() || stack.peek()[0] > price){
            stack.push(new int[]{price, 1});
            return 1;
        }

        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            int[] tmp = stack.pop();
            span+=tmp[1];
        }
        stack.push(new int[]{price, span});
        return stack.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */