class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.empty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(!stack.empty()) { 
            int val = stack.pop();
            if(!minStack.empty() && val == minStack.peek()) minStack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
