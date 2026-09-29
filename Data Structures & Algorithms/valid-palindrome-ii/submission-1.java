class Solution {
    
    public boolean validPalindrome(String s) {
        int valid = 1;
        int l = 0, r = s.length() - 1;
        if(s.length() <= 2) return true;
        
        return helper(s, 0, s.length() - 1, valid);
    }

    public boolean helper(String s, int l, int r, int valid){
        if(l >= r) return true;
        if(s.charAt(l) != s.charAt(r)){
            System.out.println("" + s.charAt(l) + " " + s.charAt(r));
            if(valid == 0) return false;
            // either delete the one on the left, or the one on the right
            return helper(s, l+1, r, valid-1) || helper(s, l, r-1, valid-1);
        }
        return helper(s, l+1, r-1, valid);
    }
}