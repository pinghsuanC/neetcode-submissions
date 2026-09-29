class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0, costTotal = 0, n = gas.length;
        for(int i = 0; i < n; i++){
            gasTotal+=gas[i];
            costTotal+=cost[i];
        }
        if(gasTotal < costTotal) return -1;

        int total = 0, start = 0;
        for(int i = 0; i < n; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                start = i+1;
                total = 0;
            }
        }

        return start;
    }
}
