class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> counts = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        for(int h : hand){
            if(!set.contains(h)){
                set.add(h);
                minHeap.offer(h);
            }
            counts.put(h, counts.getOrDefault(h, 0) + 1);
        }

        while(!minHeap.isEmpty()){
            int head = minHeap.poll(); // get the minimun
            if(counts.containsKey(head) && counts.get(head) == 0) continue;
            for(int i = head; i < head + groupSize; i++){
                if(!counts.containsKey(i) || counts.get(i) == 0) return false;
                counts.put(i, counts.get(i) - 1);
                minHeap.offer(i);
            }
        }

        return true;
    }
}
