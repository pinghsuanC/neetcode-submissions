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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode h = head;
        Stack<ListNode> stack = new Stack<>();
        while(h != null){
            stack.push(h);
            h = h.next;
            len++;
        }

        int count = 0;
        h = head;
        while(count < len/2){
            if(stack.empty()) break;
            ListNode item = stack.pop();
            ListNode tmp1 = h.next;
            ListNode tmp2 = item;
            h.next = item;
            item.next = tmp1;
            h = tmp1;
            count++;
        }
        h.next = null;
    }
}
