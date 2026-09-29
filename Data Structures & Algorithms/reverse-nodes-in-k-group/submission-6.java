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
        
        return helper(head, k);
    }

    // intuition
    // kinda need to make sure that the length we are reversing is in a group of k
    // do it recursively, when we hit a count that's less than k, return the head directly
    // else, do standard reversal, and return the new head, modify the tail.next to be the new head

    public ListNode reverse(ListNode head){
        ListNode tmp = null, pre = null, cur = head;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // pre is the new head, head is the new tail
        return pre;
    }

    public ListNode helper(ListNode head, int k){
        // check first k nodes
        if(head == null) return head;
        ListNode tmp = head;
        int count = 0;
        for(int i = 0; i < k - 1; i++){
            tmp = tmp.next;
            if(tmp == null) break;
        }

        // now we are sure the head has sth larger than k, go to the kth node, check next k
        // tmp has the next head
        if(tmp == null) return head;

        // preserve the new head
        ListNode nextHead = tmp.next;
        // reverse the tmp list
        tmp.next = null;
        ListNode newHead = reverse(head);
        
        // get the next head
        head.next = helper(nextHead, k);
        return newHead;
    }
}
