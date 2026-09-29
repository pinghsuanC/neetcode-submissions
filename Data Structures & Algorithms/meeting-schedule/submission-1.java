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
    public boolean canAttendMeetings(List<Interval> intervals) {

        Collections.sort(intervals, (a, b) -> a.start - b.start);
        Interval record = null;
        for(Interval interval : intervals){
            System.out.println(interval.start);
            if(record == null) {
                record = interval;
                continue;
            }

            if(record.end <= interval.start || record.start >= interval.end){
                record.start = Math.min(record.start, interval.start);
                record.end = Math.max(record.end, interval.end);
            } else {
                return false;
            }
        }

        return true;
    }
}
