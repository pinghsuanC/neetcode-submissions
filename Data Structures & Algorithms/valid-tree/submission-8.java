class Solution {

    List<List<Integer>> adj;
    Set<Integer> visit;
    public boolean validTree(int n, int[][] edges) {
        visit = new HashSet<>();
        adj = new ArrayList<>();

        if(edges.length > n - 1) return false;
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        if(!dfs(0, -1)){
            return false;
        }

        return visit.size() == n;
    }

    public boolean dfs(int node, int parent){
        if(visit.contains(node)) return false;

        visit.add(node);
        for(int nei : adj.get(node)){
            if(nei == parent) continue;
            if(!dfs(nei, node)) return false;
        }

        return true;
    }
}
