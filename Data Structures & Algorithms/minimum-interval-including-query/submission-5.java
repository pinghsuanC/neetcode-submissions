class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int len = intervals.length;

        // sort intervals by left_i
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // sort queries while preserving indices
        PriorityQueue<int[]> queryPairs = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 0; i < queries.length; i++) queryPairs.offer(new int[]{queries[i], i});

        // process the queries
        PriorityQueue<int[]> candidates = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int[] output = new int[queries.length];
        int j = 0;
        while(!queryPairs.isEmpty()){
            int[] queryItem = queryPairs.poll();
            int q = queryItem[0], ind = queryItem[1];

            for(; j < len && intervals[j][0] <= q; j++) candidates.offer(intervals[j]);
            while(!candidates.isEmpty() && candidates.peek()[1] < q) candidates.poll();

            if(candidates.isEmpty()){
                output[ind] = -1;
            } else {
                int[] item = candidates.peek();
                output[ind] = item[1] - item[0] + 1;
            }
        }

        return output;
    }
}
