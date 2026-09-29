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
        // 1. get the middle point
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part1 = head;
        ListNode part2 = slow.next;
        slow.next = null;

        // 2. reverse the second list
        part2 = reverse(part2);

        // 3. zip them together
        while(part2 != null){
            ListNode tmp1 = part1.next;
            ListNode tmp2 = part2.next;
            part1.next = part2;
            part2.next = tmp1;
            part1 = tmp1;
            part2 = tmp2;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode h = head;
        ListNode pre = null;
        while(h != null){
            ListNode tmp = h.next;
            h.next = pre;
            pre = h;
            h = tmp;
        }

        return pre;
    }

}
