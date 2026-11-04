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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        intuition: user 2 pointers to maintain the distance
        once the faster one hits the end, remove the slow.next, slow.next = slow.next.next

        */

        ListNode dummy = new ListNode(), node1 = dummy, node2 = head;
        dummy.next = head;
        for(int i = 0; i < n; i++) node2 = node2.next;

        while(node2 != null){
            node1 = node1.next;
            node2 = node2.next;
        }

        ListNode tmp = node1.next;
        node1.next = node1.next.next;
        if(tmp != null) tmp.next = null;

        return dummy.next;
    }
}
