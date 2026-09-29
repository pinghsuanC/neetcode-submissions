class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;

        // Completely before newInterval
        while (i < intervals.length &&
               intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Overlapping newInterval
        while (i < intervals.length &&
               intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged newInterval
        res.add(newInterval);

        // Completely after newInterval
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}