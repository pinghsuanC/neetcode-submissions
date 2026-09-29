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
            for(int i = start; i < start + groupSize; i++){
                if(!counts.containsKey(i) || counts.get(i) == 0) return false;
                counts.put(i, counts.get(i) - 1);
            }
            minHeap.offer(start);
        }

        return true;
    }
}
