class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // handle special case
        
        int[] a = nums1;
        int[] b = nums2;
        if(a.length > b.length){
            int[] tmp = a;
            a = b;
            a = tmp;
        }

        int pt1 = 0, pt2 = 0, m = a.length, n = b.length;
        int median1 = -1, median2 = -1, count = (m + n) / 2 + 1;
        while(count > 0){
            median2 = median1;
            if(pt1 < m && pt2 < n){
                if(a[pt1] < b[pt2]){
                    median1 = a[pt1];
                    pt1++;
                } else {
                    median1 = b[pt2];
                    pt2++;
                }
            } else if(pt1 < m) {
                median1 = a[pt1];
                pt1++;
            } else {
                median1 = b[pt2];
                pt2++;
            }

            count--;
        }

        if((m+n) % 2 == 1){
            return (double)median1;
        }
        return (median1 + median2) / 2.0;
    }
}
