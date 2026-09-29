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
        // intuition: use a hashmap to track the nodes, and then rebuild the relationships

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        Node newHead = map.get(head);
        Node dummy = newHead;
        cur = head;
        while(dummy != null){
            if(cur.next != null) dummy.next = map.get(cur.next);
            if(cur.random != null) dummy.random = map.get(cur.random);
            dummy = dummy.next;
            cur = cur.next;
        }
        return newHead;
    }
}
