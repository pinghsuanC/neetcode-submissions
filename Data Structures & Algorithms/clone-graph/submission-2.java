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
        // connected graph
        // keep a map of oldNode -> newNode
        // add new node to queue
        // until queue empty
        //      pop node as currentNode
        //      for each oldNeighbours, if not exist in the map, create a new node.
        //          add new neighbour reference to currentNode neighrbous
        //      add each oldNeighbours to queue

        if(node == null) return node;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        oldToNew.put(node, new Node(node.val));

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            // clone neighbors
            if(cur.neighbors.size() == 0) continue;
            for(Node nei : cur.neighbors){
                Node neiClone;
                if(oldToNew.containsKey(nei)){
                    neiClone = oldToNew.get(nei);
                } else {
                    neiClone = new Node(nei.val);
                    oldToNew.put(nei, neiClone);
                    queue.offer(nei);
                }
                oldToNew.get(cur).neighbors.add(neiClone);
            }
        }

        return oldToNew.get(node);
    }
}