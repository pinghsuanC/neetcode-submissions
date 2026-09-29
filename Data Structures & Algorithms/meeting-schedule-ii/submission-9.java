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

        for(int i = 0; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(rooms.isEmpty()){
                rooms.offer(cur.end);
                continue;
            }

            int check = rooms.peek();
            if(check <= cur.start){
                rooms.poll();
                rooms.offer(cur.end);
            } else {
                rooms.offer(cur.end);
            }
        }
        
        return rooms.size();
    }
}
