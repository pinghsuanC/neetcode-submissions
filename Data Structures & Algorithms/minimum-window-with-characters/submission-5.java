class Solution {
    public String minWindow(String s, String t) {
        /*
        intuition:
        sliding window
        valid window length min = string t

        edge case:
        if len s < len t, it's not possible, just return empty string

        if any of the frequencies in the window < frequencies if that letter in t, the window becomes invalid, move r to the right
        expand right pointer until substring (left, right) contains the valid t
        need to keep track of the frequency of letters with in the window
        as moving left pointer, deduce frequencies in the window
        

        there is another method to calculate the "match" when moving the window
        but for this practice i will be using the original sliding window solution
        */


        int lenT = t.length(), lenS = s.length();
        if(lenS < lenT || lenS == 0 || lenT == 0) return "";

        int[] freqT = new int['z' - 'A' + 1];
        int[] freqWin = new int['z' - 'A' + 1];

        // get the frequency in the window
        for(int i = 0; i < lenT; i++){
            freqT[t.charAt(i) - 'A']++;
            freqWin[s.charAt(i) - 'A']++;
        }

        // check if we have a match, if we already have a match, plurge it
        if(isWindowValid(freqT, freqWin)) return s.substring(0, lenT);

        int l = 0, r = lenT, 
            start = l,
            len = Integer.MAX_VALUE;
        while(r <= lenS){
            if(l >= r) break;
            // check if the new window is valid with the additional right
            if(isWindowValid(freqT, freqWin)){
                // if window valid, try to mvoe the left pointer while keeping it valid
                if(r - l < len){
                    start = l;
                    len = Math.min(len, r - l);
                }

                // remove left letter, move left pointer to the next letter to remove
                freqWin[s.charAt(l) - 'A']--;
                l++;
            } else {
                if(r == lenS) break; // don't need to check more if the window is not even valid when r is at the end
                freqWin[s.charAt(r) - 'A']++;
                r++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len); 
    }

    private boolean isWindowValid(int[] freqTarget, int[] freqWin){
        for(int i = 0; i < 'z' - 'A' + 1; i++){
            if(freqWin[i] < freqTarget[i]) return false;
            
        } 
        return true;
    }
}
