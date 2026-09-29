class Solution {
    private List<Integer> visiting;
    private Set<Integer> members;
    private List<List<Integer>> adj;
    public int[] findRedundantConnection(int[][] edges) {
        // intuition: 
        // Given that the raph was connected + had no cycle
        // Within a cycle, removing any edge will make the graph a valid non-cyclical
        // So the key is to find the members of the cycle + find which edge appears the last in the edges

        // To find members of the cycle: dfs at each parent, to explore the path to the parent
        // To get which edge was the last fro the edges, loop edges from the back

        // Some other observations:
        // If a node has only 1 neighbour, it's impossible for it to be in a circular relationship
        // because there is no other paths that can reach it


        visiting = new ArrayList<>();
        members = new HashSet<>();
        adj = new ArrayList<>();
        int n = edges.length;
        for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        for(int i = 0; i < n+1; i++){
            if(adj.get(i).size() <= 1) continue;
            if(!dfs(i, -1)) break;
        }
        System.out.println(members);
        for(int i = n-1; i >=0; i--){
            if(members.contains(edges[i][0]) && members.contains(edges[i][1])) return edges[i];
        }
        
        return new int[]{};
    }

    private boolean dfs(int node, int parent){
        if(visiting.contains(node)){
            for(int k : visiting){
                members.add(k);
            }
            return false;
        }
        visiting.add(node);
        for(int nei : adj.get(node)){
            if(nei == parent) continue;
            if(!dfs(nei, node)) return false;
        }
        visiting.remove(visiting.size() - 1);
        return true;
    }
}





