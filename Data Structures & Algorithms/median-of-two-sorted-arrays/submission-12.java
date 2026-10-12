class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        -> given size m and n known, && both are ascending
        -> find kth
            -> find (m + n) / 2 and (m + n) / 2 + 1 th
        */
        int m = nums1.length, n = nums2.length;
        if((m+n) % 2 != 0){
            return (double) findKth(nums1, nums2, (m + n) / 2 + 1, m, n, 0, 0);
        } else {
            int a = findKth(nums1, nums2, (m + n) / 2 + 1, m, n, 0, 0);
            int b = findKth(nums1, nums2, (m + n) / 2, m, n, 0, 0);
            return ((double)a + b) / 2;
        }

    }

    public int findKth(int[] a, int[] b, int k, int numA, int numB, int indexA, int indexB){
        // make sure what's left in a is longer
        if(numA < numB){
            return findKth(b, a, k, numB, numA, indexB, indexA);
        }

        // base case: arr2 is exhausted, so it's what's left in arr1
        if(numB == 0) return a[indexA + k - 1];
        if(k == 1) return Math.min(a[indexA], b[indexB]);

        // find # elemetns to eliminate
        int i = Math.min(numA, k/2),
            j = Math.min(numB, k/2);

        if(a[indexA + i - 1] < b[indexB + j - 1]){
            return findKth(a, b, k - i, numA - i, numB, indexA + i, indexB);
        } else {
            return findKth(a, b, k - j, numA, numB - j, indexA, indexB + j);
        } 

    }
}
