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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];

        int m = start + (end - start) / 2;
        ListNode left = helper(lists, start, m);
        ListNode right = helper(lists, m+1, end);

        return merge2Lists(left, right);
    }

    public ListNode merge2Lists(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = a, cur2 = b;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if(cur1 != null) cur.next = cur1;
        if(cur2 != null) cur.next = cur2;
        return dummy.next;
    }
}
