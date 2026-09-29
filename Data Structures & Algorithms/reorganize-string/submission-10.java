class Solution {
    public String reorganizeString(String s) {
        /*
        intuition:
        1. if there is a count that's more than half of the string length, it's not possible to get it, return ""
        2. make a frequency map of the letters
        3. at each round, find the one with the max count
            -> it's going to be the character selected
            -> find the letter with the next-best count, it's going to be the next choice
        4. return the result
        */

        int n = s.length();
        int[] freq = new int[26];
        int max = 0;
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
            max = Math.max(max, freq[c-'a']);
        }
        if(max > (n + 1) / 2) return "";

        StringBuilder res = new StringBuilder();
        while(res.length() < n){
            int maxIndex = findMaxIndex(freq, -1);
            res.append((char)(maxIndex + 'a'));
            freq[maxIndex]--;

            if(freq[maxIndex] == 0) continue; // just gonna find the next best

            // in the case that it's not 0 yet, it may interfere with finding the next answer, so we find it here
            int nextBest = findMaxIndex(freq, maxIndex);
            res.append((char) (nextBest + 'a'));
            freq[nextBest]--;
        }

        return res.toString();
    }

    public int findMaxIndex(int[] freq, int skip){
        int max = -1;
        for(int i = 0; i < freq.length; i++){
            if(i == skip) continue;
            if(max == -1 || freq[i] > freq[max]) max = i;
        }

        return max;
    }
}