class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0; i < n; i++){
            int newIndex = m + i;
            nums1[newIndex] = nums2[i];
            // move it to the correct position
            while(newIndex > 0 && nums1[newIndex] < nums1[newIndex-1]){
                int tmp = nums1[newIndex-1];
                nums1[newIndex-1] = nums1[newIndex];
                nums1[newIndex] = tmp;
                newIndex--;
            }
        }
    }
}