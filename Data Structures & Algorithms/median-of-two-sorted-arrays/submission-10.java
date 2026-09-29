class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int a = getKth(nums1, nums2, m, n, 0, 0, (m + n + 1) / 2);
        int b = getKth(nums1, nums2, m, n, 0, 0, (m + n + 2) / 2);
        return (a + b) / 2.0;
    }

    private int getKth(int[] a, int[] b, int lenA, int lenB, int aStart, int bStart, int k){
        if(lenA > lenB){
            return getKth(b, a, lenB, lenA, bStart, aStart, k);
        }

        if(lenA == 0) return b[bStart + k - 1];
        if(k == 1) return Math.min(a[aStart], b[bStart]);

        int i = Math.min(lenA, k / 2),
            j = Math.min(lenB, k / 2);
        
        if(a[aStart + i - 1] < b[bStart + j - 1]){
            return getKth(a, b, lenA - i, lenB, aStart + i, bStart, k - i);
        } else {
            return getKth(a, b, lenA, lenB - j, aStart, bStart + j, k - j);
        }
    }
}
