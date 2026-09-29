class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTimeTracker = new int[n];
        Arrays.fill(minTimeTracker, Integer.MAX_VALUE);
        minTimeTracker[k - 1] = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        for(int[] t : times) adj.get(t[0] - 1).add(new int[]{t[1], t[2]});
        // u -> (v, t)

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k - 1);

        while(!q.isEmpty()){
            int u = q.poll();
            for(int[] nei : adj.get(u)){
                int v = nei[0] - 1, t = nei[1];
                int newTime = minTimeTracker[u] + t;
                if (newTime < minTimeTracker[v]) {
                    minTimeTracker[v] = Math.min(newTime, minTimeTracker[v]);
                    q.offer(v);
                }
            }
        }

        int max = minTimeTracker[0];
        for(int i = 0; i < n; i++) {
            if(i != k-1 && minTimeTracker[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, minTimeTracker[i]);
        }

        return max;
    }
}
