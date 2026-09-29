class Solution {
    public String reorganizeString(String s) {
        /*
        Intuition:
        - Heap: retrieve the letters
        - cooldown queue: can be added back at the end of the next retrieval

        dump everything into heap with asic valie as ranging
        while heap not empty or queue not empty
        -> retrieve one letter c from heap, append to String
        -> while heap.peak() == c, retrieve and dump to queue
        -> if queue not empty, while queue.peek() != c, poll queue add to heap

        -> after attempting to get items from queue if heap is empty and queue is not empty, it means we return ""


        return accumulated string

        */

        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c - 'a']++;

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            if(a == b) return 0;
            if(count[a - 'a'] == count[b - 'a']) return a - b;
            return Integer.compare(count[b - 'a'], count[a - 'a']);
        });
        Queue<Character> queue = new ArrayDeque<>();

        for(char c : s.toCharArray()) pq.offer(c);
        String res = "";
        while(!pq.isEmpty() || !queue.isEmpty()){
            Character c = pq.poll();
            res+=c;
            count[c- 'a']--;
            while(!pq.isEmpty() && pq.peek() == c) queue.offer(pq.poll());
            while(!queue.isEmpty() && queue.peek() != c) pq.offer(queue.poll());
            if(pq.isEmpty() && !queue.isEmpty()) return "";
        }

        return res;
    }
}















