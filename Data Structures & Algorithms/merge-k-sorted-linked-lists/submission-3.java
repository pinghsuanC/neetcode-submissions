/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        // general idea
        // treat each head as a provider, gradually consume
        // use priority queue (min heap) to get the first n elements
        // each of the head we get [Node1, Node_after_Node1] pair

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        
        for(ListNode head : lists){
            if(head == null) continue;
            queue.offer(head);
        }

        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            if(cur.next != null) queue.offer(cur.next);

            cur.next = null;
            res.next = cur;
            res = res.next;
        }



        return dummy.next;
    }
}
