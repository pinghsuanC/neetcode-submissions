class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] != a[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for(int[] interval : intervals){
            queue.offer(interval);
        }

        int res = 0;
        int[] first = queue.poll();
        while(!queue.isEmpty()){
            int[] next = queue.poll();
            if(first[1] <= next[0]){
                // valid to merge
                first[1] = next[1];
            } else {
                res++;
            }
        }

        return res;
    }
}
