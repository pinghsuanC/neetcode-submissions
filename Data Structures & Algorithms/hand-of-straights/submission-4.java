class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        
        Map<Integer, Integer> counts = new HashMap<>();
        for(int h : hand) counts.put(h, counts.getOrDefault(h, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int k : counts.keySet()) minHeap.offer(k);

        while(!minHeap.isEmpty()){
            int start = minHeap.poll();
            if(!counts.containsKey(start) || counts.get(start) == 0) continue;
            counts.put(start, counts.get(start) - 1);
            for(int i = 1; i < groupSize; i++){
                int next = start + i;
                if(!counts.containsKey(next) || counts.get(next) == 0) return false;
                counts.put(next, counts.get(next) - 1);
            }
            minHeap.offer(start);
        }

        return true;
        
    }
}
