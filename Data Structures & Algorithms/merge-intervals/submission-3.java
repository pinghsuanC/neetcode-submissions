class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            // overlap
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(intervals[i][1], cur[1]);
            } else {
                res.add(new int[]{cur[0], cur[1]});
                cur = intervals[i];
            }
        }

        res.add(cur);

        int[][] resArray = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) resArray[i] = res.get(i);

        return resArray;
    }
}
