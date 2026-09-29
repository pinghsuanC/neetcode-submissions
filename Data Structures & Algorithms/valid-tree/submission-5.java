class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        Queue<int[]> q = new ArrayDeque<>();
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        q.offer(new int[]{0, -1});
        visited.add(0);

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];
            for(int nei : adj.get(node)){
                if(nei == parent) continue;
                if(visited.contains(nei)) return false;
                visited.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return visited.size() == n;
    }
}
