class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int max = -1;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            int cur = s.charAt(r) - 'A';
            freq[cur]++;
            maxFreq = Math.max(freq[cur], maxFreq);
            while(l <= r && (r - l + 1) - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            System.out.println(l + " " + r);
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
