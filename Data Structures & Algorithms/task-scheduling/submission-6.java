class Solution {
    public int leastInterval(char[] tasks, int n) {
        // intuition: need a heap & a cooling queue
        // put all the tasks into a conut map
        // use heap to get the highest number, dump all the non-zero counts into heap
        // after processing it, push it to cool down queue
        // for each loop of t, release the items that have valid time from queue
        

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();    // int[]{number, validTime}
        int[] counts = new int[26];

        for(char c : tasks) counts[c - 'A']++;
        for(int c : counts){
            if(c > 0) heap.offer(c);
        }

        int t = 0;
        while(!heap.isEmpty() || !q.isEmpty()){
            t++;
            
            if(!heap.isEmpty()) {
                int task = heap.poll() - 1;
                if(task > 0){
                    q.offer(new int[]{task, t + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == t){
                heap.offer(q.poll()[0]);
            }
        }

        return t;
    }
}
