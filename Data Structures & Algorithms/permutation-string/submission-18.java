class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int matches = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++; 
        }

        for(int i = 0; i < 26; i++){
            if(freq1[i] == freq2[i]) matches++;
        }

        int l = 0, r = s1.length();
        while(r < s2.length()){
            if(matches == 26) return true;

            // check left pointer
            int lChar = s2.charAt(l) - 'a';
            if(freq1[lChar] == freq2[lChar]) matches--;
            freq2[lChar]--;
            if(freq1[lChar] == freq2[lChar]) matches++;

            // check right pointer
            int rChar = s2.charAt(r) - 'a';
            if(freq1[rChar] == freq2[rChar]) matches--;
            freq2[rChar]++;
            if(freq1[rChar] == freq2[rChar]) matches++;

            r++;
            l++;
        }

        return matches == 26;
    }
}
