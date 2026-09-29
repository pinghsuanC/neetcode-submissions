class Solution {
    public String longestDiverseString(int a, int b, int c) {
        /*
        intuition:

        -> create frequency map
        -> create a function to find the maximun count index, index == 'a' + letter
            (note the type conversion)
        -> find the best index to use
            -> find the maximun index, skipping the previous index
                (note: don't need to check prev == prev before, since we already maximize the use, can't take repeat ones)
            -> if can't find the next best index, reutrn current string builder
        -> decide the number of indices to use
            -> if freq[maxIndex] > (totalCount + 1) / 2, use 2
            -> else use 1
            -> update the frequency map & the totalCount accordingly
        */

        int totalCount = a + b + c;
        int[] freq = new int[3];
        freq[0] = a;
        freq[1] = b;
        freq[2] = c;

        StringBuilder res = new StringBuilder();
        int prev = -1;
        while(true){
            int maxIndex = findMaxIndex(freq, prev);
            if(maxIndex == -1) break;
            
            int use = 1;
            if(freq[maxIndex] > (totalCount + 1) / 2) use = 2;

            res.append((char) (maxIndex + 'a'));
            if(use == 2) res.append((char) (maxIndex + 'a'));
            freq[maxIndex]-=use;
            totalCount-=use;
            prev = maxIndex;
        }
        
        return res.toString();
    }

    private int findMaxIndex(int[] freq, int skip){
        int index = -1;
        for(int i = 0; i < freq.length; i++){
            if(i == skip) continue;
            if(index == -1 || freq[index] < freq[i]) index = i;
        }
        if(freq[index] == 0) return -1;
        return index;
    }
}