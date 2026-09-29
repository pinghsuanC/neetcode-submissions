class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
        intuitions
        -> constructing under the contraints we have in the question
            -> at most 2 consecutive same letters
            -> at most a, b, c of each letter 'a, b, c'
            -> go as far as you can go
        
        1. Use max heap to retrieve the max count letter, use that letter
        2. retrieve 2 max count letters, append them, and throw back to the heap, this ensures the interlace
            If the count of the letter is more than half of the total count, use it more aggressively
            a=2, b=6, c=1, 6 > (6 + 1 + 2 + 1) / 2
            -> round 1, retrieve b， use 2 bs => "bb", a = 2, b = 4, c = 1.
                -> because we used b twice, can't use b again, throw it in a colldown queue
            -> round 2, retrieve a, use a => "bba"
                2 < (2 + 4 + 1 + 1) / 2, use once
                -> queue is not empty, get b out of queue a = 1, b = 4, c = 1.
            -> round 3, retrieve b again
                -> now 4 > (4 + 1 + 1) / 2 still, use b twice again
                => "bbabb"
                b = 2, throw back to queue 
            -> round 4, retrieve c => "bbabbc 
                retrieve from queue and add back to heap -> a = 1, b = 2, c = 0.
            -> round 5, retrieve b, use twice => "bbabbcbb", a = 1, b = 0, c = 0
            -> round 6, only a left => "bbabbcbba"
        
        
        track total counts totalCount
        minHeap to grab the maxCount letter
        queue to colldown one round
        */

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((first, second) -> Integer.compare(second[1], first[1]));
        if(a!=0) maxHeap.offer(new int[]{0, a});
        if(b!=0) maxHeap.offer(new int[]{1, b});
        if(c!=0) maxHeap.offer(new int[]{2, c});
        int totalCount = a + b + c;

        StringBuilder res = new StringBuilder();
        int preLetter = -1;
        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();

            int letter = first[0];
            int count = first[1];

            if (letter == preLetter) {
                // Can't use this one, need another letter
                if (maxHeap.isEmpty()) break;

                int[] second = maxHeap.poll();

                // Put first back untouched
                maxHeap.offer(first);

                letter = second[0];
                count = second[1];
            } 

            int use = (count > (totalCount + 1) / 2) ? 2 : 1;
            res.append((char) ('a' + letter));
            if(use == 2) res.append((char) ('a' + letter));
            totalCount-=use;

            if (count - use > 0) {
                maxHeap.offer(new int[]{letter, count - use});
            }

            preLetter = letter;
        }

        return res.toString();
    }
}