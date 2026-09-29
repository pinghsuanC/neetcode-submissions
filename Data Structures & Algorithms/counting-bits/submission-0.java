class Solution {
    public int[] countBits(int n) {
        int[] output = new int[n+1];
        for(int i = 0; i <= n; i++){
            output[i] = count(i);
        }
        return output;
    }

    public int count(int k){
        int count = 0;
        while(k!=0){
            count += (k & 1);
            k >>>= 1;
        }
        return count;
    }
}
