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
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (Interval cur : intervals){
            if(rooms.isEmpty()){
                rooms.offer(cur.end);
                continue;
            }

            int check = rooms.peek();
            if(check <= cur.start) rooms.poll();
            rooms.offer(cur.end);
        }
        
        return rooms.size();
    }
}
