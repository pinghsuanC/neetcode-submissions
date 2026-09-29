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
    int max;
    public int pairSum(ListNode head) {
        // use fast-and-slow-pointer to get the mid point
        // reverse the second list
        // add and get maximun
    
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(fast.val + " " + slow.val);
        ListNode mid = slow.next;
        slow.next = null;

        ListNode l1 = reverse(mid);
        ListNode l2 = head;
        int res = Integer.MIN_VALUE;
        while(l1 != null){
            res = Math.max(res, l1.val + l2.val);
            l2 = l2.next;
            l1 = l1.next;
        }

        return res;
    }

    private ListNode reverse(ListNode head){
        ListNode cur = head, pre = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    


}