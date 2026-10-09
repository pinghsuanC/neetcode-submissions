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

/*
notes

deepcopy
1. node itself
2. neighbour clones
3. relationship clone
    -> hashmap to store old address -> new address

    -> use queue, or maybe just create on the spot

*/

class Solution {
    HashMap<Node, Node> nodeMap;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.val <= 1 && node.neighbors.size() == 0) return new Node(node.val);

        nodeMap = new HashMap<>();

        cloneNode(node);

        return nodeMap.get(node);
    }

    public void cloneNode(Node node){
        if(node == null) return;
        if(nodeMap.containsKey(node)) return;

        nodeMap.putIfAbsent(node, new Node(node.val));
        Node newNode = nodeMap.get(node);

        for(Node nei : node.neighbors){
            cloneNode(nei);
            Node newNei = nodeMap.get(nei);
            newNode.neighbors.add(newNei);
        }
    }
}









