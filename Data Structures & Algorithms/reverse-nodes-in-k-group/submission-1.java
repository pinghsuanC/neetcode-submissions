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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode check = head;
        for(int i = 0; i < k; i++){
            if(check == null) return head;
            check = check.next;
        }
        
        
        int count = 0;
        ListNode pre = null, cur = head;
        while(cur != null && count < k){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            count++;
        }

        head.next = reverseKGroup(cur, k);
        return pre;
    }

}
