class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /* intuition: a car can move to the next station only when 
            gas - cost > 0
            therefore any positive (gas - cost) can be the starting point
        */
        int n = gas.length;
        int[] diff = new int[n];
        int sumGas = 0, sumCost = 0;
        for(int i = 0; i < n; i++){
            diff[i] = gas[i] - cost[i];
            sumGas+=gas[i];
            sumCost+=cost[i];
        }

        if(sumGas < sumCost) return -1;

        int total = 0, res = 0;
        for(int i = 0; i < gas.length; i++){
            total+=diff[i];
            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }

        return res;
    }
}
