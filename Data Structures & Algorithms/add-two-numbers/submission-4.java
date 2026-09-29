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

        while(cur1 != null || cur2 != null){
            int total = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + carry;
            curSum.next = new ListNode(total % 10);
            carry = total / 10;
            curSum = curSum.next;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }

        if(carry > 0){
            curSum.next = new ListNode(carry);
        }

        return sum.next;
    }
}
