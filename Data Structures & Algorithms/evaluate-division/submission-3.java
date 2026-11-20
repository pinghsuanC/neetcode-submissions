class Solution {
    Map<String, List<Node>> adj;
    Set<String> visited;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        Intuition:
        last time's solution needs addtiional class, but it should be able to be replaced by lists or maps... so here we go

        -> contruct the bidirectional adjacency map
        -> dfs the map
            note that whever returned needs to be multiplied

        */


        adj = new HashMap<>();
        Map<String, Node> nodeMap = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            double value = values[i];

            Node a = new Node(eq.get(0), value);
            Node b = new Node(eq.get(1), 1/value);

            adj.putIfAbsent(eq.get(0), new ArrayList<Node>());
            adj.putIfAbsent(eq.get(1), new ArrayList<Node>());

            adj.get(eq.get(0)).add(b);
            adj.get(eq.get(1)).add(a);

            nodeMap.put(eq.get(0), a);
            nodeMap.put(eq.get(1), b);
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            List<String> q = queries.get(i);
            String start = q.get(0), target = q.get(1);
            
            Node startNode = nodeMap.get(start);
            visited = new HashSet<String>();
            res[i] = 1 / dfs(startNode, target);
        }
        
        return res;
    }

    private double dfs(Node node, String target){
        if(node == null) return -1.0;
        if(node.node.equals(target)) return 1.0;
        if(!adj.containsKey(node.node) || !adj.containsKey(target)) return -1;
        
        visited.add(node.node);
        for(Node nei : adj.get(node.node)){
            if(visited.contains(nei.node)) continue;
            
            double res = dfs(nei, target);
            if (res == -1) continue;
            return nei.weight * res;
        }
        
        return -1.0;
    }

    class Node {
        String node;
        double weight;

        Node(String node, double weight){
            this.node = node;
            this.weight = weight;
        }
    }
}