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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){ return list2; }
        if(list2 == null){ return list1; }
        ListNode h1 = list1;
        ListNode h2 = list2;
        ListNode cur;
        ListNode pre;
        ListNode head;

        if(h1.val > h2.val){
            head = h2;
            cur = h2;
            pre = h1;
        } else {
            head = h1;
            cur = h1;
            pre = h2;
        }

        while(cur != null && cur.next != null){
            if(cur.next.val < pre.val){
                cur = cur.next;
            }else {
                ListNode tmp;
                tmp = cur.next;
                cur.next = pre;
                cur = pre;
                pre = tmp;
            }
        }

        if(pre != null){
            cur.next = pre;
        }

        return head;
    }
}