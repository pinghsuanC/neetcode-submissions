class Edge {
    Node end;
    double value;

    Edge(Node v, double val){
        end = v;
        value = val;
    }

    public String toString(){
        return end.name + " " + value;
    }
}


class Node{
    String name;
    List<Edge> edges;

    Node(String n){
        name = n;
        edges = new ArrayList<>();
    }

    public void addNeighbour(Node b, double val){
        for(Edge edge : edges){
            if(edge.end.name.equals(b.name)) return;
        }
        edges.add(new Edge(b, val));
    }

    public String toString(){
        return name;
    }
}


class Solution {
    Set<String> visited;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        equations[i] = [Ai, Bi]
        values[i] -> the qeuation Ai / Bi = values[i]

        Each pair represents a directed edge from Ai to Bi, with the valid on the edge
        if want to find Bi -> Ai, use 1/value on the edge of Ai and Bi
        
        */

        HashMap<String, Node> nodeFinder = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            double val = values[i];
            List<String> equa = equations.get(i);
            String nameA = equa.get(0), nameB = equa.get(1);

            Node a = nodeFinder.computeIfAbsent(nameA, Node::new);
            Node b = nodeFinder.computeIfAbsent(nameB, Node::new);

            a.addNeighbour(b, val);
            b.addNeighbour(a, 1.0/val);
        }

        double[] res = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++){
            List<String> q = queries.get(i);
            String u = q.get(0), v = q.get(1);
            visited = new HashSet<>();  // initialize visited
            double val = dfs(nodeFinder.get(u), v);
            res[i] = val;
        }

        return res;
    }

    private double dfs(Node node, String targetNode){
        if(node == null || node.edges.size() == 0)  return -1; // reached the end, no other way to go
        if(node.name.equals(targetNode)) return 1;

        visited.add(node.name);
        for(Edge edge : node.edges){
            if(visited.contains(edge.end.name)) continue;
            visited.add(edge.end.name);
            if(edge.end.name.equals(targetNode)){
                return edge.value;
            }
            double val = dfs(edge.end, targetNode);
            if(val != -1) return edge.value * val;
        }

        return -1;
    }
}












