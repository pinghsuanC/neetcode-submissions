class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        intuition: process queue + cooldown queue
        Since we want the minimum number of CPU cycles, start with the tasks with the max number
        don't need to track the actual task, just need the count of the tasks

        */

        int[] count = new int[26];
        PriorityQueue<Integer> processQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Queue<int[]> coolDownQueue = new ArrayDeque<>();
        int t = 0;

        for(char task : tasks) count[task - 'A']++;
        for(int c : count){
            if(c == 0) continue;
            processQueue.offer(c);
        }

        while(!processQueue.isEmpty() || !coolDownQueue.isEmpty()){

            // skip to the next available in cooldown Queue if processQueue is empty
            if(processQueue.isEmpty() && !coolDownQueue.isEmpty()){
                t = coolDownQueue.peek()[1] + 1;
                processQueue.offer(coolDownQueue.poll()[0]);
            }

            if(!processQueue.isEmpty()){
                int process = processQueue.poll();
                process--;
                if(process > 0){
                    // add to cooldown queue
                    coolDownQueue.offer(new int[]{process, t + n});
                }
            }

            while(!coolDownQueue.isEmpty() && coolDownQueue.peek()[1] <= t){
                processQueue.offer(coolDownQueue.poll()[0]);
            }


            t++;
        }


        return t;
    }
}
