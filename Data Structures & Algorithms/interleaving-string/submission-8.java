class Solution {
    boolean[][] tab;
    public boolean isInterleave(String s1, String s2, String s3) {
        /*
        intuition:

        writing in bottom-up fashino (need to clean up the state first in the recursion)
        
        */

        if(s1.length() + s2.length() != s3.length()) return false;

        int m = s1.length(), n = s2.length();

        tab = new boolean[m + 1][n + 1];
        tab[m][n] = true;

        for(int i = m; i>=0; i--){
            for(int j = n; j >=0; j--){
                if(i < m && s1.charAt(i) == s3.charAt(i+j) && tab[i+1][j]){
                    tab[i][j] = true;
                }
                if(j < n && s2.charAt(j) == s3.charAt(i+j) && tab[i][j+1]){
                    tab[i][j] = true;
                }
            }
        }


        return tab[0][0];
    }

}
