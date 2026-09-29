class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTimeTracker = new int[n];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for(int[] t : times) adj.get(t[0] - 1).add(new int[]{t[1], t[2]});
        // u -> (v, t)

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(k - 1);
        visited[k - 1] = true;

        while(!q.isEmpty()){
            int u = q.poll();
            for(int[] nei : adj.get(u)){
                int v = nei[0] - 1, t = nei[1];
                if(!visited[v]){
                    minTimeTracker[v] = minTimeTracker[u] + t;
                    visited[v] = true;
                    q.offer(v);
                } else if(minTimeTracker[v] > minTimeTracker[u] + t){
                    minTimeTracker[v] = minTimeTracker[u] + t;
                    q.offer(v);
                }
            }
        }

        int max = minTimeTracker[0];
        for(int i = 0; i < n; i++) {
            System.out.println(minTimeTracker[i]);
            if(i != k-1 && minTimeTracker[i] == 0) return -1;
            max = Math.max(max, minTimeTracker[i]);
        }

        return max;
    }
}
