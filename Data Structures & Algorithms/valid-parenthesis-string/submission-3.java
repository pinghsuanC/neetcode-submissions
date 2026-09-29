class Solution {
    public boolean checkValidString(String s) {
        int minLeft = 0, maxLeft = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                minLeft++;
                maxLeft++;
            } else if (s.charAt(i) == ')'){
                minLeft--;
                maxLeft--;
            } else {
                minLeft--;
                maxLeft++;
            }

            if(maxLeft < 0) return false;
            minLeft = Math.max(minLeft, 0);
        }

        return minLeft == 0;
    }
}
