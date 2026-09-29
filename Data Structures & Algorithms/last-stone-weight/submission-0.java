class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : stones){
            minHeap.offer(n);
        }

        while(minHeap.size() > 1){
            int diff = minHeap.poll() - minHeap.poll();
            if(diff > 0){
                minHeap.offer(diff);
            }
        }

        if(minHeap.size() == 0) return 0;

        return minHeap.peek();
    }
}
