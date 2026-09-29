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
    public ListNode reverseList(ListNode head) {
        if(head == null){ return head; }
        ListNode p = head;
        ListNode pre = null;
        while(p.next != null){
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        p.next = pre;
        return p;
    }
}
