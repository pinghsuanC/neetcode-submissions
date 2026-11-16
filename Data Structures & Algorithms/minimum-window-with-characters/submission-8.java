class Solution {
    public String minWindow(String s, String t) {
        /*
        same idea but implemented in the count of matches method
        
        */



        int lenS = s.length(), lenT = t.length(), matches = 0, required = 0;
        int l = 0, r = lenT, start = l, minLen = Integer.MAX_VALUE, numLetters = 'z' - 'A' + 1;

        if(lenS == 0 || lenT == 0 || lenS < lenT) return "";

        int[] freqT = new int[numLetters];
        int[] freqWin = new int[numLetters];

        for(int i = 0; i < lenT; i++){
            freqT[t.charAt(i) - 'A']++;
            freqWin[s.charAt(i) - 'A']++;
        }

        for(int i = 0; i < numLetters; i++){
            if(freqT[i] > 0) required++;
            if(freqT[i] > 0 && freqWin[i] >= freqT[i]) matches++;
        }

        if(matches == required) return s.substring(l, l+lenT);

        while(r <= lenS){
            // no match, get into the window

            // try to remove the left letter @l if it's a valid window
            if(matches == required){
                if(r - l < minLen){
                    start = l;
                    minLen = r - l;
                }

                // if it matches, now it doesn't match, decreate the matches
                int L = s.charAt(l) - 'A';
                freqWin[L]--;
                if(freqWin[L] < freqT[L]) matches--;                
                l++;
                
            } else {
                // try to add the right letter @r
                if(r == lenS && matches != required) break;

                // if it didn't match before, but mathces now, increase the matches
                int R = s.charAt(r) - 'A';

                freqWin[R]++;
                if(freqWin[R] == freqT[R]) matches++;
                r++;
            }

        }


        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
