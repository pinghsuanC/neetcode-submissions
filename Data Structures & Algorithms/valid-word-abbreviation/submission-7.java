class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        // if they are the same string, return true
        if(word.equals(abbr)) return true;
        if(word.length() == 0) return false;
        // check if abbr is a integer itself. if so word length has to match
        try{
            int len = Integer.parseInt(abbr);
            return len == word.length();
        } catch(Exception e){
            // no need to do anything
        }

        // now l and r sides of abbr starts with letters
        int ptWord = 0, ptAbbr = 0;
        while(ptWord < word.length()){
            if(word.charAt(ptWord) == abbr.charAt(ptAbbr)){
                ptWord++;
                ptAbbr++;
                continue;
            }
            
            // character mismatch & have a number in abbr
            if(abbr.charAt(ptAbbr) <= '9' && abbr.charAt(ptAbbr) > '0'){
                // get the full number
                int end = ptAbbr + 1;
                while(end < abbr.length() && abbr.charAt(end) <= '9') end++;
                int n = Integer.parseInt(abbr.substring(ptAbbr, end));
                while(n > 0){
                    ptWord++;
                    n--;
                }
                ptAbbr=end;
                
            } else {
                // mismatch + it's not a number
                return false;
            }
        }

        if(ptWord > word.length()) return false;
        if(ptWord == word.length()) return ptAbbr == abbr.length();

        return true;
    }
}