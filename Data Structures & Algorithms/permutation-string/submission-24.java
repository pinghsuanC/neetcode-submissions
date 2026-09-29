class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            intuition:
            we have a set of characters for s1, SetA
            
            when we move the sliding windows in s2, with the length of s1
            we move 1 letter out of the way (l++)
            and move 1 letter inside (r++)

            so the question is to check if string l to r is a permutation of s1
            -> mathes method
            -> or just simply create the frequency maps

            will do it by creating frequency maps
        */

        if(s2.length() < s1.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        // initialize the frequency maps
        for(char c : s1.toCharArray()) freq1[c-'a']++;
        int l = 0, r = s1.length();
        for(int i = l; i < r; i++) freq2[s2.charAt(i) - 'a']++;

        if(checkMaps(freq1, freq2)) return true;

        // start moving the windows
        while(r < s2.length()){
            
            int remove = s2.charAt(l) - 'a';
            int add = s2.charAt(r) - 'a';

            // update the frequency table for the next window
            freq2[remove]--;
            freq2[add]++;

            if(checkMaps(freq1, freq2)) return true;

            l++;
            r++;
        }
        return false;
    }


    // to check if 2 frequency maps are equal, equal == permutation
    private boolean checkMaps(int[] freq1, int[] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]) return false;
        }

        return true;
    }
}
