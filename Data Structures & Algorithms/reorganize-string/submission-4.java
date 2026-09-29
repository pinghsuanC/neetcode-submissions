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

        note: need to make sure the highest count is the first option by checking & updating counts

        */

        int[] count = new int[26];
        int maxFreq = 0;
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
            maxFreq = Math.max(maxFreq, count[c - 'a']);
        }
        if(maxFreq > (s.length() + 1) / 2) return "";

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
            if(count[a - 'a'] == count[b - 'a']) return a - b;
            return Integer.compare(count[b - 'a'], count[a - 'a']);
        });
        Queue<Character> queue = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) pq.offer(c);
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty() || !queue.isEmpty()){
            Character c = pq.poll();
            res.append(c);
            count[c- 'a']--;
            if(count[c - 'a'] > 0) queue.offer(c);
            while(!queue.isEmpty() && queue.peek() != c) pq.offer(queue.poll());
            if(pq.isEmpty() && !queue.isEmpty()) return "";
        }

        return res.toString();
    }
}















