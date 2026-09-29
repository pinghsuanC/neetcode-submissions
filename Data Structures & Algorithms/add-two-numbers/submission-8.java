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
        
        ListNode pt1 = l1, pt2 = l2;
        ListNode ans = new ListNode(),
                cur = ans;
        int carry = 0;

        while(pt1 != null || pt2 != null){
            int pt1Val = pt1 != null ? pt1.val : 0;
            int pt2Val = pt2 != null ? pt2.val : 0;
            int total = pt1Val + pt2Val + carry;

            int res = total % 10;
            carry = total / 10;
            cur.next = new ListNode(res);
            cur = cur.next;
            if(pt1 != null) pt1 = pt1.next;
            if(pt2 != null) pt2 = pt2.next;
        }

        if(carry != 0){
            cur.next = new ListNode(carry);
        }


        return ans.next;
    }
}
