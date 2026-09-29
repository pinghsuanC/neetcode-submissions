class Solution {
    public String reorganizeString(String s) {
        /*
        intuition

        -> create frequency map, index == letter - 'a'
            -> while you are doing it, get the maximun count of letters
            -> if max > (len of s + 1) / 2, then it's imposisble, plurge by returning ""
        -> each time, get the maximun that is not the previous letter
        -> continue until can't find the next index (-1)
        -> check if the previous letter has anything left, if so return ""
        -> else return the result String
        */

        int[] freq = new int[26];
        int max = -1;
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            max = Math.max(max, freq[c - 'a']);
        }

        if(max == -1) return "";

        StringBuilder res = new StringBuilder();
        int prev = -1;
        while(res.length() < s.length()){
            // find the max letter to use right now
            int maxIndex = findMaxIndex(freq, prev);
            if(maxIndex == -1) return "";
            res.append((char) (maxIndex + 'a'));
            freq[maxIndex]--;
            
            prev = maxIndex;
        }

        return res.toString();
    }

    private int findMaxIndex(int[] freq, int skip){
        int index = -1;
        for(int i = 0; i < freq.length; i++){
            if(skip == i) continue;
            if(index == -1 || freq[index] < freq[i]) index = i;
        }

        if(freq[index] == 0) return -1;

        return index;
    }
}