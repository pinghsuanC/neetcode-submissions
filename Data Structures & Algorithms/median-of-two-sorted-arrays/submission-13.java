class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if((m+n) % 2 != 0){
            return (double) findKth(nums1, nums2, (m + n) / 2 + 1, 0, 0, m, n);
        } else {
            int a = findKth(nums1, nums2, (m + n) / 2 + 1, 0, 0, m, n);
            int b = findKth(nums1, nums2, (m + n) / 2, 0, 0, m, n);
            return ((double)a + b) / 2;
        }
    }

    public int findKth(int[] a, int[] b, int k, int startA, int startB, int lenA, int lenB){
        if(lenA < lenB){
            return findKth(b, a, k, startB, startA, lenB, lenA);
        }

        if(lenB == 0) return a[startA + k - 1];
        if(k == 1) return Math.min(a[startA], b[startB]);

        int i = Math.min(lenA, k/2),
            j = Math.min(lenB, k/2);

        if(a[startA + i - 1] < b[startB + j - 1]){
            return findKth(a, b, k-i, startA + i, startB, lenA - i, lenB);
        } else {
            return findKth(a, b, k-j, startA, startB + j, lenA, lenB - j);
        }
    }
}
