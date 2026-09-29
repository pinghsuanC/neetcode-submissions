class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] tracker = new int[n+1];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        Queue<Integer> q = new ArrayDeque<>();

        // build adjacency list
        for(int[] time : times){
            int u = time[0], v = time[1], t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        // sort each dependency based on time cost
        for(List<int[]> arr : adj) arr.sort((a, b) -> a[1] - b[1]);


        // starting point
        q.offer(k);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] nei : adj.get(cur)){
                int v = nei[0], t = nei[1];
                int newT = tracker[cur] + t;
                if(tracker[v] == 0 || tracker[v] > newT){
                    tracker[v] = newT; // cascade the changes
                    q.offer(v);
                }
            }
        }

        // calculate the cost, or -1 if ineffective
        int cost = 0;
        for(int i = 1; i < n+1; i++){
            if(i == k) continue;
            if(tracker[i] == 0) return -1;
            cost = Math.max(cost, tracker[i]);
        }
        
        return cost;
    }
}
