class Solution {
    private List<List<Integer>> adj;
    private Set<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        // thought:
        // create adj list as usual
        // create a visited set. intiialize count = 0
        // have a queue to go through all the nodes
        // for each node, if it's visited, continue;
        // if not, count++, and dfs the node

        // void dfs, goal is to collect nodes within a graph
        // in dfs, if it's visited, return as we hit a cycle
        // else dfs each neighbour
        adj = new ArrayList<>();
        visited = new HashSet<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int count = 0;
        for(int node = 0; node < n; node++){
            if(visited.contains(node)) continue;
            count++;
            dfs(node);
        }

        return count;
    }

    private void dfs(int node){
        if(visited.contains(node)) return;
        visited.add(node);
        for(int i : adj.get(node)){
            dfs(i);
        }
    }
}








