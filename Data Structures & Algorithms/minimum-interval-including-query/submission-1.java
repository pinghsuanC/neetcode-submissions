class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int len = intervals.length;

        // sort intervals based on length
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int query = queries[i];
            int j = 0;
            while(j < len && intervals[j][0] > query) j++;
            if(j == len) {
                res[i] = -1;
                continue;
            }
            
            while(j < len && intervals[j][0] <= query){
                if(intervals[j][1] < query) {
                    j++;
                    continue;
                }
                res[i] = Math.min(res[i] > 0 ? res[i] : intervals[j][1] - intervals[j][0] + 1, intervals[j][1] - intervals[j][0] + 1);
                j++;
            }

            if(res[i] == 0) res[i] = -1;
        }

        return res;
    }
}
