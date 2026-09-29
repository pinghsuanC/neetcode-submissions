class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        intuitions: 
        
        use a two-pointer to find the combined middle of two arrays
        pt1 -> nums1[i]
        pt2 -> nums2[j]

        if pt1 < pt2, move pt2 to the next number (using index)
        count++

        -> consider odd / even amount of numbers
        odd -> find (m + n) / 2 th
        even -> find (m + n) / 2 and (m + n) / 2 + 1
        
        So do it until count = (m + n) / 2 + 1, with pt1 and pt2
        */

        // handle special cases : empty arrays?

        //

        int m = nums1.length, n = nums2.length, mid = (m + n) / 2;
        int i = 0, j = 0, pt1 = 0, pt2 = 0, count = 0;

        while(count < mid + 1){
            pt2 = pt1;
            if(i < m && j < n){
                if(nums1[i] > nums2[j]){
                    pt1 = nums2[j];
                    j++;
                } else {
                    pt1 = nums1[i];
                    i++;
                }
            } else if (i < m){
                pt1 = nums1[i];
                i++;
            } else {
                pt1 = nums2[j];
                j++;
            }

            count++;
        }

        if((m + n) % 2 != 0) return (double) pt1;

        return ((double)pt1 + pt2) / 2;
    }
}
