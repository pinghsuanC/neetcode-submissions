class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE / 2;
        int[][] dist = new int[n+1][n+1];
        for(int[] d : dist) Arrays.fill(d, inf);

        for(int[] time : times){
            int u = time[0], v = time[1], w = time[2];
            dist[u][v] = w;
        }

        for(int mid = 0; mid <=n; mid++){
            for(int i = 0; i <= n; i++){
                dist[i][i] = 0;
                for(int j = 0; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[mid][j] + dist[i][mid]);
                }
            }
        }

        dist[k][0] = -1;
        int res = Arrays.stream(dist[k]).max().getAsInt();
        return res == inf ? -1 : res;
    }
}
