class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // intuition with the matches method
        // first get the frequency tables for s1
        // and then get the frequency table for 0 to s1.length() of s2
        // calculate the # of matches there are in two frequency tables
        // if it == 26, return true
        // else start the while loop with l = 0, r = s1.length until r reaches s2's end
        // check if freq[charAt(l)] matche in two, increment an decrement the matches accordingly
        // do the same for r
        if(s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int matches = 0;

        for(int i = 0; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(freq1[i] == freq2[i]) matches++;    
        }

        if(matches == 26) return true;

        int l = 0, r = s1.length();
        while(r < s2.length()){
            int a = s2.charAt(l) - 'a';
            int b = s2.charAt(r) - 'a';

            // remove char at l
            freq2[a]--;
            if(freq1[a] == freq2[a]) matches++;
            if(freq1[a] == freq2[a] + 1) matches--;

            // add char at r
            freq2[b]++;
            if(freq1[b] == freq2[b]) matches++;
            if(freq1[b] == freq2[b] - 1) matches--;

            if(matches == 26) return true;
            l++;
            r++;
        }

        return false;
    }
}






