class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /* just a review from yesterday*/

        // the car, sort with destination cloest to farthest
        PriorityQueue<int[]> car = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        // sort ppl who are waiting form cloest to farthest
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        int totalLoad = 0;
        for(int[] trip : trips){
            int num = trip[0], begin = trip[1], end = trip[2];

            // see if there are unloads done before the next trip
            while(!car.isEmpty() && car.peek()[2] <= begin){
                int[] unload = car.poll();
                totalLoad-=unload[0];
            }

            // load the trip
            totalLoad+=num;
            if(totalLoad > capacity) return false;
            car.offer(trip);
        }

        return true;        
    }
}