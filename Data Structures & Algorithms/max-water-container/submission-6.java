class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, max = Integer.MIN_VALUE;

        while(l < r){
            // why would we move the pointers?
            max = Math.max(max, Math.min(heights[r], heights[l]) * (r - l));
            if(heights[l] <= heights[r]){ // we need maximize the height of both bars, for potentially largest area
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
