class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // trying the accumulative count method
        int L = Integer.MAX_VALUE, R = Integer.MIN_VALUE;
        for(int[] trip : trips){
            L = Math.min(L, trip[1]);
            R = Math.max(R, trip[2]);
        }

        int N = R - L + 1;
        int[] passengerCounts = new int[N];
        for(int[] trip : trips){
            passengerCounts[trip[1] - L]+=trip[0];
            passengerCounts[trip[2] - L]-=trip[0];
        }

        int curPass = 0;
        for(int change : passengerCounts){
            curPass+=change;
            if(curPass > capacity){
                return false;
            }
        }

        return true;
    }
}