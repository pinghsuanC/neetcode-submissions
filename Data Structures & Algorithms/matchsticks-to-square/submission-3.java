class Solution {
    int TARGET;
    boolean res;
    public boolean makesquare(int[] matchsticks) {
        /*
        intuition: you can't break sticks, but can bag sticks
        kackbag issue?

        it needs to be able to be divided by 4 at least
        and each stick shouldn't be more than 1/4 of total length, worth plunging before going into actual checking
        */

        int total = Arrays.stream(matchsticks).sum();
        int max =  Arrays.stream(matchsticks).max().getAsInt();
        if(total % 4 != 0) return false;

        int target = total / 4;
        if(max > target) return false;
        Arrays.sort(matchsticks);
        TARGET = target;
        res = false;

        boolean[] taken = new boolean[matchsticks.length];
        helper(matchsticks, taken, 0, 0);

        return res;
    }

    private void helper(int[] sticks, boolean[] taken, int acc, int countBucket){
        if(countBucket == 4) {
            res = true;
            return;
        }
        if(res) return;
    
        for(int i = 0; i < sticks.length; i++){
            if(taken[i]) continue;
            if(i > 1 && !taken[i-1] && sticks[i] == sticks[i-1]) continue;
            
            int newVal = sticks[i] + acc;
            if(newVal > TARGET) return;
            if(newVal == TARGET){
                taken[i] = true;
                helper(sticks, taken, 0, countBucket + 1);
                taken[i] = false;
            } else {
                taken[i] = true;
                helper(sticks, taken, newVal, countBucket);
                taken[i] = false;
            }
        }
    }

    
}