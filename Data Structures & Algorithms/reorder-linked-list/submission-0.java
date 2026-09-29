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
        while(h != null){
            h = h.next;
            len++;
        }

        ListNode part1 = head;
        ListNode part2 = head;
        int count = 0;
        while(count <= len/2 && part2 != null){
            part2 = part2.next;
            count++;
        }

        count = 0;
        while(count <= len/2 - 1){
            part1 = part1.next;
            count++;
        }
        part1.next = null;

        // Reverse part2
        part1 = head;
        part2 = reverse(part2);
        

        // zip two lists together
        ListNode tmp1;
        ListNode tmp2;
        while(part2 != null){
            tmp1 = part1.next;
            tmp2 = part2.next;
            part1.next = part2;
            part2.next = tmp1;
            part2 = tmp2;
            part1 = tmp1;
        }

        head = part1;
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
