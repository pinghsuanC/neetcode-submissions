class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[] cur = intervals[0];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > cur[1]){
                res.add(cur);
                cur = intervals[i];
            } else {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }

        res.add(cur);

        int[][] resArr = new int[res.size()][];
        for(int i = 0; i < res.size(); i++) resArr[i] = res.get(i);

        return resArr;
    }
}
