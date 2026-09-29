class Solution {
    public String reorganizeString(String s) {
        /*
        Intuition:
        - findMaxIndex: returns the index with the max frequency count at this moment
        
        -> calculate frequency counts
        -> if max exceeds (len + 1) / 2, return ""
        -> while length of new string is less than the string given
            -> use the max frequency item @ maxIndex
            -> update frequency count -- 
            -> find the next-largest maxIndex, update maxIndex with it
        

        return accumulated string

        note: need to make sure the highest count is the first option by checking & updating counts

        */

        int[] count = new int[26];
        int maxFreq = 0;
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
            maxFreq = Math.max(maxFreq, count[c - 'a']);
        }
        if(maxFreq > (s.length() + 1) / 2) return "";

        StringBuilder res = new StringBuilder();
        while(res.length() < s.length()){
            int maxInd = findMaxIndex(count, -1);
            res.append((char) (maxInd + 'a'));
            count[maxInd]--;

            if(count[maxInd] == 0) continue;

            int nextBestInd = findMaxIndex(count, maxInd);
            res.append((char) (nextBestInd + 'a'));
            count[nextBestInd]--;
        }

        return res.toString();
    }

    private int findMaxIndex(int[] freq, int exclude){
        int max = -1;
        for(int i = 0; i < freq.length; i++){
            if(i == exclude) continue;
            if(max == -1 || freq[i] > freq[max]) max = i;
        }
        return max;
    }
}















