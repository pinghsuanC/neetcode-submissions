class Solution {
    public int maxTurbulenceSize(int[] arr) {
        /*
        intuition

        "Turbulent" definition, the sign flips between
        Can do it just like the maxum subarray, but by checking the comparison with the next slot

        reset to 0, and set the expectation (sign) to -1 (ready for any new start) if it's not a turbulent situation


        */

        int sign = -1, maxLen = 0, curLen = 0;

        for(int i = 0; i < arr.length - 1; i++){
            int n = arr[i], next = arr[i+1];

            if(n > next){
                curLen = (sign == 0) ? curLen+1 : 1;
                sign = 1;
            } else if(n < next) {
                curLen = (sign == 1) ? curLen+1 : 1;
                sign = 0;
            } else {
                curLen = 0;
                sign = -1;
            }

            maxLen = Math.max(curLen, maxLen);
        }

        return maxLen + 1;
    }
}