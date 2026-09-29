/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() <= 1) return intervals.size();
        boolean[] used = new boolean[intervals.size()];
        int room = 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        while(true){

            boolean hasUnused = false;
            for(boolean u : used) if(u == false) hasUnused = true;
            if(!hasUnused) break;
            
            for(int i = 0; i < intervals.size(); i++){
                if(used[i]) continue;
                Interval interval = intervals.get(i);
                room++;
                used[i] = true;
                for(int j = 1; j < intervals.size(); j++){
                    if(used[j]) continue;
                    Interval interval2 = intervals.get(j);
                    if(interval2.start >= interval.end) {
                        interval.end = interval2.end;
                        used[j] = true;
                    } 
                }
            }
        }

        return room;
    }
}
