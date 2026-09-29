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
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(Interval interval : intervals){
            if(endTime.isEmpty()){
                endTime.offer(interval.end);
                continue;
            }

            if(interval.start >= endTime.peek()) endTime.poll();
            endTime.offer(interval.end);
        }

        return endTime.size();
    }
}
