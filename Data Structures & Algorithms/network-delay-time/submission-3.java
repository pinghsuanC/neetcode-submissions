class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] tracker = new int[n+1];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        // get the adjacency list
        System.out.println(adj);
        for(int i = 0; i < times.length; i++){
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k); // starting point

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int[] nei : adj.get(cur)){
                int u = nei[0], t = nei[1];
                int newTime = tracker[cur] + t;
                // first visit or got a time that's larger
                if(tracker[u] == 0 || tracker[u] > newTime){
                    tracker[u] = newTime;
                    queue.offer(u); // queue will cascade the changes
                }
            }
        }

        int t = 0;
        for(int i = 1; i < n+1; i++){
            if(tracker[i] == 0 && i != k) return -1;
            if(i == k) continue;
            t = Math.max(t, tracker[i]);
        }

        return t;
    }
}
