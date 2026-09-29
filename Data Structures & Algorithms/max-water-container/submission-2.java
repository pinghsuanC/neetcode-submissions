class Solution {
    public int maxArea(int[] heights) {
        int l=0, r = heights.length - 1, res = 0;
        while(l < r){
           int area = Math.min(heights[r], heights[l]) * (r - l);
           res = Math.max(area, res);
           if(heights[r]>heights[l]){
                l++;
           } else {
                r--;
           }
        }
        return res;
    }
}
