class Solution {
    int target;
    Integer[][] tabula;
    public boolean stoneGame(int[] piles) {
        /*
        intuition
        
        // given
        piles.length == even
        each pile > 0

        end with the most stones
        total # of stones across all piles == odd (there must be at least one left over)

        either choose the beginning or the end
        the other player does the same


        // Alice starts first
        since optimize, you can either start at head or at the tail, if either wins Alice wins (assumed alice is a optimized computer)
        total # choices = length / 2
        -> at position 0, each made a selection, therefore the next selection when i==1 is either 
            -> (i+1) and (len - i - 1) if the other side took i
            -> (i) and (len - i - 2) if the other side took [len - i - 1]
        */

        int sum = Arrays.stream(piles).sum();
        target = sum / 2 + 1; // has to have this much to win the game
        tabula = new Integer[piles.length][piles.length];
        int aliceBest = helper(piles, 0, 0, 0);
        reverse(piles);

        tabula = new Integer[piles.length][piles.length];
        int reverseBest = helper(piles, 0, 0, 0);

        return aliceBest >= target || reverseBest >= target;
    }

    // reverse inplace
    public void reverse(int[] arr){
        for(int i = 0; i < arr.length /2; i++){
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1] ;
            arr[arr.length - i - 1] = tmp;
        }
    }

    public int helper(int[] piles, int i, int count, int acc){
            if(count >= piles.length / 2 || i >= piles.length) return acc;
            if(tabula[i][count] != null) return tabula[i][count];
            
            // selecting position i
            int selectI = helper(piles, i+1, count+1, acc+piles[i]);

            // don't select position i, select the end
            int selectEnd = helper(piles, piles.length - 1 - i, count+1, acc+piles[piles.length - 1 - i]);

            tabula[i][count] = Math.max(selectI, selectEnd);

            return tabula[i][count];
    }

    
}







