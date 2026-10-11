class MyStack {

    Queue<Integer> queue1;

    public MyStack() {
        queue1 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
        for (int i = queue1.size() - 1; i > 0; i--) {
            queue1.offer(queue1.poll());
        }
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */