class Solution {
    boolean[] visited;
    List<List<int[]>> adj;
    Integer[][] dp;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // flights[i] = [from_i, to_i, price_i]
        visited = new boolean[n];
        adj = new ArrayList<>();
        dp = new Integer[n][n];

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // adj: from -> int[]{to, price} directed graph
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int res = dfs(src, dst, 0, k);
        return res;
    }

    public int dfs(int start, int target, int count, int k){
        if(start == target) return 0;
        if(count > k) return -1;
        if(dp[start][count] != null) return dp[start][count];
        
        int res = -1;
        for(int[] nei : adj.get(start)){
            //if(visited[nei[0]]) continue; // avoid cycle
            int dist = dfs(nei[0], target, count+1, k);
            if(dist < 0) continue;
            int total = dist + nei[1];
            if (res == -1 || total < res) res = total;
        }

        dp[start][count] = res;
        return dp[start][count];
    }
}
