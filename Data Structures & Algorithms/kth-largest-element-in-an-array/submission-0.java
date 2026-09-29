class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : nums){
            queue.offer(n);
        }

        for(int i = 0; i < k-1; i++){
            queue.poll();
        }

        return queue.peek();
    }
}
