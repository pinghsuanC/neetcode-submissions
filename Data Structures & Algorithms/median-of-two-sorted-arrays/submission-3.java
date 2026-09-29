class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,
            n = nums2.length;
        boolean isOdd = (m + n) % 2 == 1;
        
        if(isOdd){
            return findKth(nums1, m, nums2, n, (m+n)/2+1, 0, 0);
        } else {
            return (findKth(nums1, m, nums2, n, (m+n)/2+1, 0, 0)
                + findKth(nums1, m, nums2, n, (m+n)/2, 0, 0))/ 2.0;
        }
    }

    public int findKth(int[] a, int m, int[] b, int n, int k, int aStart, int bStart){
        if(m > n) return findKth(b, n, a, m, k, bStart, aStart);
        if(m == 0) return b[bStart + k - 1]; 
        if(k == 1) return Math.min(a[aStart], b[bStart]);

        int i = Math.min(m, k/2);
        int j = Math.min(n, k/2);

        if(a[aStart + i - 1] < b[bStart + j - 1]){
            return findKth(a, m-i, b, n, k-i, aStart+i, bStart);
        }else{
            return findKth(a, m, b, n-j, k-j, aStart, bStart+j);
        }
    }
}
