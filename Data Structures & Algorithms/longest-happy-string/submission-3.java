class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
        intuitions
        -> constructing under the contraints we have in the question
            -> at most 2 consecutive same letters
            -> at most a, b, c of each letter 'a, b, c'
            -> go as far as you can go
        
        -> instead of using heap, since there are only 3 letters, just use an frequency map of size 3 

        track total counts totalCount
        minHeap to grab the maxCount letter
        queue to colldown one round
        */

        int[] freq = new int[]{a, b, c};
        int totalCount = a + b + c;

        StringBuilder res = new StringBuilder();
        int preLetter = -1;
        while (true) {
            int letter = findMaxIndex(freq, -1);
            if(letter == -1) break;
            int count = freq[letter];

            if (letter == preLetter) {
                // Can't use this one, need another letter
                // if there is no other options, then we break it
                int secondIndex = findMaxIndex(freq, letter);
                if (secondIndex == -1) break;
                letter = secondIndex;
                count = freq[secondIndex];
            } 

            // use interlace to maximize length when remaining letter is greater than half of the total count left
            int use = 1;
            if(count > 1 && count > (totalCount + 1) / 2) use = 2;

            res.append((char) ('a' + letter));
            if(use == 2) res.append((char) ('a' + letter));

            totalCount-=use;
            freq[letter]-=use;
            preLetter = letter;
        }

        return res.toString();
    }


    private int findMaxIndex(int[] freq, int skip){
        int max = -1;
        for(int i = 0; i < freq.length; i++){
            if(i==skip) continue;
            if(max == -1 || freq[max] < freq[i]) max = i;
        }
        if(freq[max] == 0) return -1;
        return max;
    }
}