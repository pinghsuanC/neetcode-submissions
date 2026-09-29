class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        Queue<int[]> queue = new ArrayDeque<>();
        int[] freqs = new int[26];
        for(char c : tasks) freqs[c - 'A']++;
        for(int i = 0; i < 26; i++){
            if(freqs[i] > 0) maxHeap.offer(-1*freqs[i]);
        }

        int t = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            t++;
            if(!queue.isEmpty() && queue.peek()[1] == t){
                maxHeap.offer(queue.poll()[0]);
            }
            if(maxHeap.isEmpty()) continue;
            
            int ele = maxHeap.poll();
            ele++;
            if(ele == 0) continue;
            queue.offer(new int[]{ele, t+n+1});
        }
        
        return t;
    }
}
