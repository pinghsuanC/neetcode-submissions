class Solution {
    boolean ans;
    int target;
    public boolean makesquare(int[] matchsticks) {
        /*
        intuition:
        target is to have 4 same-length combinations

        - pre-calculate target, this is the only way the sticks can build a square if it mods 4
        - in the backtracking
            - assign taken and not taken in an array
            - accumulate length
            - newLen = acc + current length
            - if it exceeds target, then it can't be, continue to end the tree
            - if it equals target, a potential hit. reset the len to 0 and traverse down the array
            - else it's less than target, we can potentially add current val into the accumulation
        - if the count of accumulation reaches 4, we have a hit.
        
        each stick should be able to be the "starter stick", and also note we should skip the duplications
        */

        ans = false;
        Arrays.sort(matchsticks);
        boolean[] taken = new boolean[matchsticks.length];

        int total = Arrays.stream(matchsticks).sum();
        if(total % 4 != 0) return false;
        target = total / 4;
        for(int n : matchsticks) {
            if(n > target) return false;
        }
        
        helper(matchsticks, 0, taken, 0);
        return ans;
    }

    public void helper(int[] matchsticks, int len, boolean[] taken, int count){
        if(count == 4) {
            ans = true;
            return;
        }
        if(ans) return;
        for(int k = 0; k < matchsticks.length; k++){
            
            if(taken[k]) continue;
            
            int newLen = matchsticks[k] + len;

            // can't be taken now
            if(newLen > target) continue;
            
            // met a length that is matching the length we are looking for
            if(newLen == target){
                taken[k] = true;
                helper(matchsticks, 0, taken, count+1);
                taken[k] = false;
                return;
            } 


            // not necessary mathching, but gonna stack them together, count doesn't change since they are the same stick
            taken[k] = true;
            helper(matchsticks, newLen, taken, count);
            taken[k] = false;

        }

    }
}