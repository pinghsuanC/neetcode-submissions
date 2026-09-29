class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0, n = gas.length;

        for(int g : gas) gasSum += g;
        for(int c : cost) costSum += c;
        if(gasSum < costSum) return -1;

        int total = 0, res = 0;
        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                res = i+1;
            }
        }

        return res;
    }
}
