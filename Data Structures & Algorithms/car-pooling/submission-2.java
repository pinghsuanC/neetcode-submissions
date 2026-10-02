class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        notes & intuition:
        - capacity
        - only drives east
        - trips[i] = [numPassengers[i], from[i], to[i]], so int[] array each of size 3
            pick up trips[i][0] people from trips[i][1] to drop to trips[i][2]
            -> pick up k people from Xkm and drop to Ykm from 0

        Intuition
        - check if it's possible to pick up and drop off all passengers from all given trips
            -> does the trip satisfy the capacity requirements
            -> if at anypoint the capacity overflows, we can't do it

        Intuition:
            -> one-way trip, can only increase distance travelled
            -> At any km, you unload and load, check the capacity
            
            -> To pick up passengers, use a min heap or just sort with X. that's the closest passengers you have to get
            -> To simulate the load, use min heap on Y, that's the cloest you can get to unload.
            -> keep track of the load versus capacity. if load > capacity at any point, it's not possible
            -> if we can unload safely, return true
        */

        int n = trips.length;

        // get heap
        PriorityQueue<int[]> groups = new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> car = new PriorityQueue<>((a, b)->Integer.compare(a[2], b[2]));

        for(int[] trip : trips) groups.offer(trip);

        int total = 0, distance = 0;
        while(!groups.isEmpty() || !car.isEmpty()){
            
            // unload @ destination
            while(!car.isEmpty() && distance == car.peek()[2]){
                int[] k = car.poll();
                total-=k[0];
            }
            // load @ stops
            while(!groups.isEmpty() && distance == groups.peek()[1]){
                int[] k = groups.poll();
                car.offer(k);
                total+=k[0];
            }
            if(total > capacity) return false;

            // if car is empty, check the next groups to load
            if(car.isEmpty() && !groups.isEmpty()){
                int firstStop = groups.peek()[1];
                while(!groups.isEmpty() && groups.peek()[1] == firstStop){
                    int[] add = groups.poll();
                    car.offer(add);
                    total+=add[0];
                }
                distance = firstStop;
                if(total > capacity) return false;
            }

            distance++;
        }



        return true;
    }
}