class Solution {
    /*
    intuition: first thought of disjoint union, but it'd be painful to implements
    do going for dfs/bfs first

    first build the graph
    then start to visit the edges in BFS
    if an edgie
    */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        // bidirectional
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 1) queue.offer(i);
        }

        while(!queue.isEmpty()){
            // visit the parent
            int cur = queue.poll();
            indegree[cur]--;
            // visit its neighbours
            for(int nei : adj.get(cur)){
                indegree[nei]--;
                if(indegree[nei] == 1) queue.offer(nei);
            }
        }

        // need the last one valid
        for(int i = n-1; i >= 0; i--){
            int u = edges[i][0], v = edges[i][1];
            if(indegree[u] > 0 && indegree[v] > 0){
                return new int[]{u, v};
            }
        }

        return new int[0];
    }
}
