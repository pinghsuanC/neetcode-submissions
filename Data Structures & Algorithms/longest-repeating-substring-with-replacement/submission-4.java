class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int l = 0, maxF=0, res = 0;
        for(int r = 0; r < s.length(); r++){
            int c = s.charAt(r) - 'A';
            counts[c]++;
            maxF = 0;
            for(int i = 0; i<26; i++){
                if(counts[i] > maxF) maxF = counts[i];
            }

            while((r - l + 1) - maxF > k){
                counts[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
