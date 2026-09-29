class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, totalN = m + n;
        if((m + n) %2 == 0){
            // find (m + n) / 2 th and ((m + n) / 2 + 1) th
            int a = getKth(nums1, m, nums2, n, (m + n) /2, 0, 0);
            int b = getKth(nums1, m, nums2, n, (m + n) /2 + 1, 0, 0);
            return (a + b) /2.0;
        } else {
            // find (m + n) / 2 th
            return getKth(nums1, m, nums2, n, (m + n) /2 + 1, 0, 0);
        }
    }

    private int getKth(int[] a, int m, int[] b, int n, int k, int aStart, int bStart){
        if(m > n){
            return getKth(b, n, a, m, k, bStart, aStart);
        }
        if(m == 0){
            return b[bStart + k - 1];
        }
        if(k == 1){
            return Math.min(a[aStart], b[bStart]);
        }

        int i = Math.min(m, k/2);
        int j = Math.min(n, k/2);

        if(a[aStart + i - 1] > b[bStart + j - 1]){
            return getKth(a, m, b, n-j, k-j, aStart, bStart + j);
        } else {
            return getKth(a, m - i, b, n, k - i, aStart + i, bStart);
        }

    }
}