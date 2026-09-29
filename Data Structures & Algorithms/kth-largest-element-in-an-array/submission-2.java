class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        notes

        use priority queue?
        
        */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums) {
            queue.offer(num);
            if(queue.size() > k) queue.poll();
        }

        return queue.poll();
    }
}
