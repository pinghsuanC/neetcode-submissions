/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Use a hashmap to track the nodes & cloned nodes
        //      <Node: Cloned Node>
        // Use a queue to prcocess until the nodes are exhausted
        // for a node n
            // if it doesn't exist in the hashmap, create one new node nCloned
            // add nCloned to hashmap
            // For each neighbour k of n, 
                // if it exists in the hashmap, skip it (already had the relatinoship before)
                // if it doesnt, create a clone kClone and add to hashmap
                // add to neighbour of nCloned
        // mark m as visited (maybe redundant)
        if(node == null) return node;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node newNode = new Node(node.val);
        nodeMap.put(node, newNode);
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node n = q.poll();
            Node nClone;
            if(nodeMap.containsKey(n)){
                nClone = nodeMap.get(n);
            } else {
                nClone = new Node(n.val);
                nodeMap.put(n, nClone);
            }

            for(Node k : n.neighbors){
                if(nodeMap.containsKey(k)) {
                    // skip processing as neighbourship already exists in the other node
                    nClone.neighbors.add(nodeMap.get(k));
                    continue;
                }
                Node kClone = new Node(k.val);
                nodeMap.put(k, kClone);
                nClone.neighbors.add(kClone);
                q.offer(k);
            }
        }

        return newNode;
    }


}