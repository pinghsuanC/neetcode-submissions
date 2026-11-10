/*
intuition:
    back to the heap idea, if we avoid using the timestamp... maybe it will be better


*/

class FreqStack {
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> freqMap;
    private int index;

    public FreqStack() {
        pq = new PriorityQueue<>((a, b) ->
            a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1])
        );
        freqMap = new HashMap<>();
        index = 0;
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        pq.offer(new int[]{freqMap.get(val), index++, val});
    }
    
    public int pop() {
        int[] top = pq.poll();
        int val = top[2];
        freqMap.put(val, freqMap.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */