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

            boolean found = false;
            List<Interval> list = new ArrayList<>();
            for(int j = 0; j < rooms.size() && found == false; j++){
                Interval check = rooms.poll();
                if(check.end <= cur.start){
                    check.end = cur.end;
                    rooms.offer(check);
                    found = true;
                } else {
                    list.add(check);
                }
            }
            for(Interval l : list) rooms.offer(l);
            if(!found){
                rooms.offer(cur);
            }
        }
        
        return rooms.size();
    }
}
