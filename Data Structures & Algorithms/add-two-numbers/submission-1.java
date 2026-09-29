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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode curSum = sum;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;

        while(cur1 != null && cur2 != null){
            curSum.next = new ListNode(0);
            curSum = curSum.next;
            curSum.val = (cur1.val + cur2.val + carry) % 10;
            carry = (cur1.val + cur2.val) / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        ListNode pt = (cur1 == null) ? cur2 : cur1;

        while(pt != null){
            curSum.next = new ListNode(0);
            curSum = curSum.next;
            curSum.val = (pt.val + carry) % 10;
            carry = (pt.val + carry) / 10;
            pt = pt.next;
        }

        if(carry > 0){
            curSum.next = new ListNode(carry);
        }

        return sum.next;
    }
}
