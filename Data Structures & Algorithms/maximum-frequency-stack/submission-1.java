/*
intuition:
    instead of using heap, which needs to be reheapify constantly,
    use buckets of stack to track frequencies
    

*/

class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        groupMap = new HashMap<>();
        maxFreq = Integer.MIN_VALUE;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);

        groupMap.putIfAbsent(freq, new Stack<>());
        groupMap.get(freq).push(val);

        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int val = groupMap.get(maxFreq).pop();

        freqMap.put(val, freqMap.get(val) - 1);

        if (groupMap.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */