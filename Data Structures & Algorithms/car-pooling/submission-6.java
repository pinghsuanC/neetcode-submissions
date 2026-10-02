class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        Intuition:
            -> instead of heap, sort the trips before hand and sweep from 0 to n
            -> at each step, you unload from car, and load form groups
            -> if load > capacity at any point, it's not possible
            -> if we can unload safely, return true
            -> optimization: 
             - when distance < the smallest of group.peek()[1] and car.peek()[2], set distance to the smaller of those
            - maybe instead of heap for groups, can just use sort once + index
        */

        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        // get heap
        PriorityQueue<int[]> car = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));

        int total = 0, distance = 0;
        for(int[] trip : trips){
            int numAdd = trip[0], start = trip[1], end = trip[2];
            while(!car.isEmpty() && car.peek()[2] <= start){
                int[] k = car.poll();
                total-=k[0];
            }

            car.offer(trip);
            total+=numAdd;
            if(total > capacity) return false;
        }
        

        return true;
    }
}