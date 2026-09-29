class Solution {
    public int maxArea(int[] heights) {
        int l = 0, 
            r = heights.length - 1, 
            maxV = 0;
        while(l < r){
            maxV = Math.max(maxV, (r - l) * Math.min(heights[r], heights[l]));
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return maxV;
    }
}
