/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Intuition: use map to reference nodes, oldNode -> newNode
        // for each given node
        //      -> check if it exists in the map
        //          -> if exists, grab the clone and append to list
        //          -> if not, clone and add to map, and append to list
        //      -> then check if its random exists in the map
        //          -> if exists, grab the clone and add to new node's random
        //          -> if not, clone the random, add to new node random, add to map

        Node dummy = new Node(0);
        Node cur = dummy;
        Node h = head;
        Map<Node, Node> oldToNew = new HashMap<>();
        while(h!=null){
            Node clone;
            if(oldToNew.containsKey(h)){
                clone = oldToNew.get(h);
            } else {
                clone = cloneNode(h);
                oldToNew.put(h, clone);
            }
            Node random;
            if(oldToNew.containsKey(h.random)){
                random = oldToNew.get(h.random);
                clone.random = random;
            }else{
                if(h.random != null){
                    random = cloneNode(h.random);
                    oldToNew.put(h.random, random);
                    clone.random = random;
                }
            }
            cur.next = clone;
            cur = cur.next;
            h = h.next;
        }
        return dummy.next;
    }

    private Node cloneNode(Node node){
        if(node == null) return null;
        return new Node(node.val);
    }
}
