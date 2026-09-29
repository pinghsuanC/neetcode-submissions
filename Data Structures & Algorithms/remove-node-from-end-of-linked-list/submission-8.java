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
        // intuition: kinda list fast-slow pointer, but with dedicated space between
        // let a pointer cur run n+1 times first
        // then use point the target pointer at the head.
        // this way, their distance between will be n.
        // run two pointers till the end, target.next will be the one to be removed
        // this covers the edge cases too (may need to closely examed)

        if(head == null) return head;

        ListNode cur = head,
            dummy = new ListNode(0),
            tar = dummy;
            tar.next = head;
        
        for(int i = 0; i < n && cur !=null; i++){
            cur = cur.next;
        }
        
        while(cur!=null){
            cur = cur.next;
            tar = tar.next;
        }
        
        tar.next = tar.next.next;
        
        return dummy.next;
    }
}
