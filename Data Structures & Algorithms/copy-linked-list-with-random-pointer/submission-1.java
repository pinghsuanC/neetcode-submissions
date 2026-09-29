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
        Map<Node, Node> map = new HashMap<>();
        Node old = head;
        Node copy = clone(old);
        Node pt = copy;  // save head
        while(old != null){
            map.put(old, copy);
            if(old.next != null){
                if(map.get(old.next) == null){
                    map.put(old.next, clone(old.next));
                }
                copy.next = map.get(old.next);;
            }
            if(old.random != null){
                if(map.get(old.random) == null){
                    map.put(old.random, clone(old.random));
                }
                copy.random = map.get(old.random);;
            }
            old = old.next;
            copy = copy.next;
        }

        return pt;
    }

    public Node clone(Node node){
        if(node == null) return null;
        Node copy = new Node(node.val);
        return copy;
    }
}
