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
        PriorityQueue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
        int rooms = 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i = 0; i < intervals.size(); i++){
            Interval k = intervals.get(i);
            if(queue.isEmpty()){
                rooms++;
                queue.offer(k);
                continue;
            }

            // queue is not empty
            Stack<Interval> tmp = new Stack<>();
            boolean used = false;
            for(int j = 0; j < queue.size() && used == false; j++){
                Interval check = queue.poll();
                if(check.end <= k.start){
                    check.end = k.end;
                    queue.offer(check);
                    used = true;
                } else {
                    tmp.push(check);
                }
            }
            for(Interval s : tmp) queue.offer(s);
            if(!used){
                rooms++;
                queue.offer(k);
            }
        }
        return rooms;
    }
}
