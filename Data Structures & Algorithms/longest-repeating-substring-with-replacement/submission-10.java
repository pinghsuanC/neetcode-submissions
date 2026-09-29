class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max = 0, l = 0;
        for(int r = 0; r < s.length(); r++){
            freq[s.charAt(r) - 'A']++;
            int highestFreq = findMaxFreq(freq);
            while(highestFreq + k < (r - l + 1)){
                freq[s.charAt(l) - 'A']--;
                highestFreq = findMaxFreq(freq);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    public int findMaxFreq(int[] freqs){
        int res = freqs[0];
        for(int i : freqs){ 
            if(res < i) res = i;
        }
        return res;
    }
}
