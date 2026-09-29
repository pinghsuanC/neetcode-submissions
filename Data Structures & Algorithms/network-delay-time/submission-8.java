class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        
        for(int i = 0; i < n-1; i++){
            for(int[] time : times){
                int u = time[0] - 1, v = time[1] - 1, w = time[2];
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        int max = Arrays.stream(dist).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;

    }
}
