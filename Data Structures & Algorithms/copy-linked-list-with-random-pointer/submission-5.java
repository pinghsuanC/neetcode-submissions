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
        // Intuition: use map to store the relationship between old and cloned list
        // loop thorugh everything first, for each node, do a clone.
        // create a dummy node as the new dummy head. cur points to dummy.
        // loop again. get node from map. get random node from map. connect them.
        // return dummy.next

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, cloneNode(cur));
            cur = cur.next;
        }

        Node dummy = new Node(0);
        Node pt = dummy;
        cur = head;
        while(cur != null){
            pt.next = map.get(cur);
            if(cur.random != null){
                pt.next.random = map.get(cur.random);
            }
            pt = pt.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    private Node cloneNode(Node node){
        if(node == null) return null;
        return new Node(node.val);
    }
}
