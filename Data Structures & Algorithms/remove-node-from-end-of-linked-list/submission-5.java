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
        ListNode saveHead = head;
        ListNode cur = head, pos = head;
        int k = n, acc = 0;
        while(cur != null){
            acc++;
            if(acc >= n + 2) pos = pos.next;
            cur=cur.next;
        }
        System.out.println(pos.val);
        if(acc == n){
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        }

        pos.next = pos.next.next;

        return head;
    }
}
