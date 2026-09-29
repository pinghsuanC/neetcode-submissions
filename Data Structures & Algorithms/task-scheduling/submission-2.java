class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for(char c : tasks) freqs[c - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> q = new ArrayDeque<>();
        int t = 0;
        for(int i : freqs) if(i > 0) maxHeap.offer(i);

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            t++;
            // process
            if(!maxHeap.isEmpty()){
                int ele = maxHeap.poll();
                ele--;
                if(ele > 0) q.offer(new int[]{ele, t+n});
            }
            while(!q.isEmpty() && q.peek()[1] == t){
                maxHeap.offer(q.poll()[0]);
            }
        }

        return t;
    }
}
