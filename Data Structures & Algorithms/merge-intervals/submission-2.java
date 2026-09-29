class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            // overlap
            if(end >= intervals[i][0]){
                end = Math.max(intervals[i][1], end);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        res.add(new int[]{start, end});

        int[][] resArray = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) resArray[i] = res.get(i);

        return resArray;
    }
}
