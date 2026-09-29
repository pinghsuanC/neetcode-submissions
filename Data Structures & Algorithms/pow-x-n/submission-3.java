class Solution {
    Map<Integer, Double> tabula;
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        double res = helper(x, Math.abs((long) n));

        return (n >= 0) ? res : 1/res;
    }

    public double helper(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        
        double half = helper(x, n/2);
        return (n%2 == 0) ? half * half : x * half * half;
    }
}
