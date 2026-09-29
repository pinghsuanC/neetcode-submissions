class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLeftRight = new int[height.length];
        int[] water = new int[height.length];
        int maxL = height[0];
        for(int i=1; i<height.length; i++){
            maxLeft[i] = maxL;
            if(height[i] > maxL){
                maxL = height[i];
            }
        }
        int maxR = height[height.length-1];
        for(int j = height.length-1; j>=0; j--){
            maxRight[j] = maxR;
            if(height[j]>maxR){
                maxR = height[j];
            }
        }

        for(int i = 0; i<height.length; i++){
            minLeftRight[i] = Math.min(maxLeft[i], maxRight[i]);
            water[i] = minLeftRight[i] - height[i];
        }

        int res = 0;
        for(int i =0; i<height.length; i++){
            res+=((water[i] > 0) ? water[i] : 0);
        }

        return res;
    }
}
