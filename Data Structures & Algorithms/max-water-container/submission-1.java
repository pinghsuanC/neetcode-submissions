class Solution {
    public int maxArea(int[] heights) {
        int maxA = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int r = heights.length -1;
            while(r > 0){
                maxA = Math.max(maxA, ((r - i) * Math.min(heights[i], heights[r])));
                r--;
            }
        }
        return maxA;
    }
}
