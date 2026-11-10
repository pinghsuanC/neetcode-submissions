/*
intuitions:
given "pop the most frequent" + "closest to the stack's top", i'd think of it more of a heap structure
-> sort by frequency & timestamp (indexes basically)
use a hashmap to track the frequencies
use heap to offer the O(1) pop()
but sorting will cost log(n)

will do it this way then will see if there are ways to improve

*/



class FreqStack {
    PriorityQueue<Integer> pq;
    Map<Integer, Integer> freqMap;
    Map<Integer, List<Integer>> timestampMap;
    int timestamp = 0; // increments everytime, pretend this is a timestamp

    public FreqStack() {
        freqMap = new HashMap<>();
        timestampMap = new HashMap<>();
        /*
        pq expecting int
        */
        pq = new PriorityQueue<>((nA, nB) -> {
            List<Integer> timestampsA = timestampMap.get(nA),
                        timestampsB = timestampMap.get(nB);
            int timeA = timestampsA.get(timestampsA.size() - 1),
                timeB = timestampsB.get(timestampsB.size() - 1),
                freqA = freqMap.get(nA),
                freqB = freqMap.get(nB);
            if(freqA != freqB) return Integer.compare(freqB, freqA);
            return Integer.compare(timeB, timeA);
        });
    }
    
    public void push(int val) {
        // add to frequency Map & timestamp map
        freqMap.putIfAbsent(val, 0);
        freqMap.put(val, freqMap.get(val)+1);
        timestamp++;
        timestampMap.putIfAbsent(val, new ArrayList<>());
        timestampMap.get(val).add(timestamp);


        // add to pq
        if(!pq.contains(val)){
            pq.offer(val);
        } else {
            pq.remove(val);
            pq.offer(val);
        }
    }
    
    public int pop() {
        if(pq.isEmpty()) return -1;
        int res = pq.poll();
        freqMap.put(res, freqMap.get(res)-1);
        List<Integer> timestamps = timestampMap.get(res);
        timestamps.remove(timestamps.size() - 1);
        if(freqMap.get(res) > 0) pq.offer(res);
        
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */