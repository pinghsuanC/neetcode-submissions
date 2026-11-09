class Solution {
    public int trap(int[] height) {
        /*
        intuition: 
        width = 1 for all heights
        # water = (right - left) * width involve
        -> what is width involved?
            - Notice first you need at least 2 height > 0 to trap water
            - If 2 heights are > 0, index them L, and R, 
                - R >= L
                    - water trapped = (R - L) * Math.min(L, R) - (every height in the middle of L an R)
                - R <= L
                    -> not sure, maybe something larger will come later
        -> need to find the first R that's >= L, that's the endpoint and next starting point
            - brute force?
        
        -> Finding the highest point will allow us to split the problem in 3 sets
            -> left -> max
            -> max - max
            -> max -> right
        */

        int n = height.length, ans = 0;
        if(n < 3) return ans;
        int max = Arrays.stream(height).max().getAsInt();

        // firstPart: left -> max
        int L = 0, R = n;
        while(height[L] < 1) L++;
        R = L+1;

        while(height[L] < max){
            if(height[R] < height[L]){
                R++;
                continue;
            }

            // now height[R] >= height[L], have water trapped
            int sumBody = 0;
            for(int i = L+1; i < R; i++) sumBody += height[i];
            int water = (R - L - 1) * Math.min(height[L], height[R]) - sumBody;
            ans+=water;
            L = R;
            R = L+1;
        }

        if(L == n - 1) return ans; // stop if reached the end

        // not L is @ max, there is a possibility that there is a plataue, do a search for the same height
        for(int i = L; i < n; i++){
            if(height[i] == max) R = Math.max(R, i);
        }
        int sumBody = 0;
        for(int i = L+1; i < R; i++) sumBody += height[i];
        int water = (R - L - 1) * Math.min(height[L], height[R]) - sumBody;
        ans+=water;

        if(R == n - 1) return ans; // stop if reached the end

        // now we have anything lower than maximum on the right side, do the same thing but reversed
        int end = R; // the max point
        R = n - 1; // now we start at the end
        while(height[R] < 1) R--;
        L = R - 1;
        while(R > end){
            if(height[L] < height[R]){
                L--;
                continue;
            }
            // now we have a trap
            int body = 0;
            for(int i = R-1; i > L; i--) body+=height[i];
            int waters = Math.min(height[L], height[R]) * (R - L - 1) - body;
            ans+=waters;
            R = L;
            L = R - 1;
        }

        return ans;

    }
}
