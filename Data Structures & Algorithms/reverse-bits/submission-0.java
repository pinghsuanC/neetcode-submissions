class Solution {
    public int reverseBits(int n) {
       int p = 31;
       int k = 0;
       while(n != 0){
            if((n & 1) == 1){
                k += (1<<p);
            }
            
            n >>>= 1;
            p--;
       }

       return k;
    }
}
