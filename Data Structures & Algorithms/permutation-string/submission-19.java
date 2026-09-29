class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
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
            if(matches == 26) return true;

            // check left to be removed
            if(freq1[s2.charAt(l) - 'a'] == freq2[s2.charAt(l) - 'a']) matches--;
            freq2[s2.charAt(l) - 'a']--;
            if(freq1[s2.charAt(l) - 'a'] == freq2[s2.charAt(l) - 'a']) matches++;

            // check right to be added
            if(freq1[s2.charAt(r) - 'a'] == freq2[s2.charAt(r) - 'a']) matches--;
            freq2[s2.charAt(r) - 'a']++;
            if(freq1[s2.charAt(r) - 'a'] == freq2[s2.charAt(r) - 'a']) matches++;

            l++;
            r++;
        }

        return matches == 26;
    }
}
