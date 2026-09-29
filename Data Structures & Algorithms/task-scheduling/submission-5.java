class Solution {
    public int leastInterval(char[] tasks, int n) {
        // intuition: use a maxheap + a cooldown queue
        // calculate the frequencies of each task, dump it to the maxheap
        // until the heap is empty && queue is empty
        //  check if the top of the queue has a t = current t. if so release it and add to heap
        //  poll the next task available, reduce the frequency, add to cooldown queue if still has remaining, t2 = t + n
        // return t
    
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();
        int[] freqs = new int[26];
        for(char c : tasks) freqs[c - 'A']++;
        for(int i = 0; i < freqs.length; i++){
            if(freqs[i] > 0){
                heap.offer(freqs[i]);
            }
        }

        System.out.println(heap);

        int t = 0;
        while(!heap.isEmpty() || !q.isEmpty()){
            t++;
            while(!q.isEmpty() && q.peek()[1] == t){
                heap.offer(q.poll()[0]);
            }
            if(heap.isEmpty()) continue;
            
            int count = heap.poll();
            count--;
            if(count > 0){
                q.offer(new int[]{count, t+n+1});
            }
        }

        return t;
    }
}







