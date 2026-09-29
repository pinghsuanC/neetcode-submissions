class Solution {
    public int maxArea(int[] heights) {
        int l = 0, max = -100;
        int r = heights.length - 1;
        while(l < r){
            max = Math.max(max, (r - l) * Math.min(heights[l], heights[r]));
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
