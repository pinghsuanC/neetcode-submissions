class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        if(n == 0) return new int[]{};
        /*
        intuition: if i understand correctly... enqueue time = availability
        cpu grabs the first ever available task

        store index in the minheap items, sort tasks by enqueue time
        queue for enqueueing time, (int[]{enqueutime, processingtime, index})
        minHeap sort by processing time first and index last (int[]{enqueuetime, porocessingtime, index})
        
        enter loop to poll from queue & minheap until both of them are empty
        from int t = 0, update t to the first t from queue
        (1) deque & add to minheap until the first item in queue is not good for time t
            * if there is no good items, grab the first one, and update the t with the largest we peek from queue
        (2) minHeap has all the available items at time t. poll() to get the one with comparison we set up
        (3) since it's single threaded, t = t + processing time. 
        (5) update res[index] with index we have
        (6) Loop back to (1) 
        
        */



        // both will be expecting a int[]{enqueueTime, processingTime, index}
        Queue<int[]> queue = new ArrayDeque<int[]>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]); // smallest processing time first
            return Integer.compare(a[2], b[2]); // smallest index first
        });

        // sort and push to queue
        List<int[]> list = new ArrayList<>();
        int index = 0;
        for(int[] task : tasks){
            list.add(new int[]{task[0], task[1], index});
            index++;
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] task : list) queue.offer(new int[]{task[0], task[1], task[2]});

        int[] res = new int[n];
        int t = 0;
        index = 0; // starting position of the res array
        while(!queue.isEmpty() || !minHeap.isEmpty()){
            if(!queue.isEmpty() && queue.peek()[0] > t) t = queue.peek()[0];
            while(!queue.isEmpty() && queue.peek()[0] <= t) {
                minHeap.offer(queue.poll());
            }
            
            if(!minHeap.isEmpty()){
                int[] currentTask = minHeap.poll(); // task we are doing
                t += currentTask[1];
                res[index] = currentTask[2];
                index++;
            } else {
                // no tasks available, just increment the timer
                t++;
            }

        }


        return res;
    }
}