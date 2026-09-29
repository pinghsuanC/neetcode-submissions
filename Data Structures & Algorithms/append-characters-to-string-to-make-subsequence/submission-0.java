class Solution {
    public int appendCharacters(String s, String t) {
        // min number of char at the end of s 
        // so that t is a subsequence of s

        int ps = 0, pt = 0;
        int m = s.length(), n = t.length();

        while(ps < m && pt < n){
            if(s.charAt(ps) == t.charAt(pt)){
                ps++;
                pt++;
            } else {
                ps++;
            }
        }
        
        return n - pt;
    }
}