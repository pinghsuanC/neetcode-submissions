class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, 
            j = 0, 
            len1 = nums1.length, 
            len2 = nums2.length,
            count = (len1 + len2) / 2 + 1,
            med1 = 0, 
            med2 = 0;

        for(int k = 0; k < count; k++){
            // preserving pre value
            med2 = med1;
            if(i < len1 && j < len2){
                if(nums1[i] < nums2[j]){
                    med1 = nums1[i];
                    i++;
                } else {
                    med1 = nums2[j];
                    j++;
                }
            } else if(i < len1){
                med1 = nums1[i];
                i++;
            } else {
                med1 = nums2[j];
                j++;
            }
        }

        if((len1 + len2) % 2 == 1){
            return (double) med1;
        } else {
            return (med1 + med2) / 2.0;
        }
    }
}
