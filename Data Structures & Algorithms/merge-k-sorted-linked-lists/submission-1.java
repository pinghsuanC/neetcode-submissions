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
        /* intuition: 
            1. see each of the lists as a provider
            2. use minHeap to grab the head of each list
            3. poll one from heap. add to the build. based on which list that node was from, grab the next one from the list into the heap.
            4. do this until heap is empty 
        */

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode n : lists){
            if(n == null) continue;
            q.offer(n);
        }

        while(!q.isEmpty()){
            ListNode min = q.poll();
            if(min.next != null) q.offer(min.next);
            cur.next = min;
            min.next = null;
            cur = cur.next;
        }


        return dummy.next;
    }
}
