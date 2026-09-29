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
        PriorityQueue<Interval> rooms = new PriorityQueue<>((a, b) -> a.end - b.end);
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(rooms.isEmpty()){
                rooms.offer(cur);
                continue;
            }

            Interval check = rooms.peek();
            if(check.end <= cur.start){
                rooms.poll();
                check.end = cur.end;
                rooms.offer(check);
            } else {
                rooms.offer(cur);
            }
        }
        
        return rooms.size();
    }
}
