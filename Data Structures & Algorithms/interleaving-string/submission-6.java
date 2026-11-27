class Solution {
    Boolean[][] tab;
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        intuition:

        Need: check if s3 is formed by interleaving s1 and s2

        s = s1 + s2 + s3 + ... + sn
        t = t1 + t2 + t3 + ... + tn

        interleaving = s1 + t1 + s2 + t2 + s3 + t3...

        it comes down to whether a position can support it to split interchangeable until the end of the other string
        
        */

        tab = new Boolean[s1.length()][s2.length()];


        return helper(s1, s2, s3, 0, 0, 0);


    }


    private boolean helper(String s, String t, String target, int i, int j, int k){
        // base case needs considerations
        if(k >= target.length()){
            return i == s.length() && j == t.length();
        }
        if(i == s.length() && j == t.length()) return k == target.length();
        if(i >= s.length()){
            return target.substring(k, target.length()).equals(t.substring(j, t.length()));
        }
        if(j >= t.length()){
            return target.substring(k, target.length()).equals(s.substring(i, s.length()));
        }
        if(tab[i][j] != null) return tab[i][j];


        boolean res = false;
        char pos = target.charAt(k);
        if(pos == s.charAt(i)){
            // can take the i @ s
            res = res || helper(s, t, target, i+1, j, k+1);
        }

        if(pos == t.charAt(j)){
            // can take the j @ t
            res = res || helper(s, t, target, i, j+1, k+1);
        }

        tab[i][j] = res;

        // if there's no match, not possible
        return res;
    }



}
