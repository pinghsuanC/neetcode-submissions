class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int n = word.length(), m = abbr.length();

        // if they are the same string, return true
        if(word.equals(abbr)) return true;
        if(n == 0) return false;

        // now l and r sides of abbr starts with letters
        
        int ptWord = 0, ptAbbr = 0;
        while(ptWord < n && ptAbbr < m){
            if(abbr.charAt(ptAbbr) == '0') return false;

            if(Character.isLetter(abbr.charAt(ptAbbr))){
                if(ptWord < n && word.charAt(ptWord) == abbr.charAt(ptAbbr)){
                    ptWord++;
                    ptAbbr++;
                } else {
                    return false;
                }
            } else{
                int len = 0;
                if(Character.isDigit(abbr.charAt(ptAbbr))){
                    while(ptAbbr < abbr.length() && Character.isDigit(abbr.charAt(ptAbbr))){
                        len = len * 10 + (abbr.charAt(ptAbbr) - '0');
                        ptAbbr++;
                    }
                } 
                ptWord+=len;
            }

        }

        return ptWord == n && ptAbbr == m;
    }
}