class Solution {
    public int leastInterval(char[] tasks, int n) {
        // appoach: a max heap + a cooldownueue

        // get all the frqeuencies of tasks, dump the frequencies into the max heap.

        // Until heap is empty && queue is empty

        // increment time t

        // if there is queue.peek() that's with time t, release it from queue

        // poll a task from heap, process it by decrement counts
        // send it to colldown queue with time t+n+1

        // return t
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();

        int[] freq = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }

        for(int k : freq){
            if(k > 0) maxHeap.offer(k);
        }

        System.out.println(maxHeap);

        int t = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            t++;
            while(!q.isEmpty() && q.peek()[1] == t){
                maxHeap.offer(q.poll()[0]);
            }
            if(maxHeap.isEmpty()) continue;
            int ele = maxHeap.poll();
            ele--;
            if(ele > 0) q.offer(new int[]{ele, t+n+1});
        }

        return t;
    }
}





