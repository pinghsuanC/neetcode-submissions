class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // convert the problem to find the kth element
        int totalLen = nums1.length + nums2.length;
        if(totalLen % 2 == 1){
            return findKth(nums1, nums1.length, nums2, nums2.length, (totalLen) / 2 + 1 , 0, 0);
        }

        return (findKth(nums1, nums1.length, nums2, nums2.length, (totalLen) / 2 + 1 , 0, 0) + 
        findKth(nums1, nums1.length, nums2, nums2.length, (totalLen) / 2, 0, 0)) / 2.0;
    
    }

    public int findKth(int[] a, int lenA, int[] b, int lenB, int k, int aStart, int bStart){
        if(lenA > lenB){
            return findKth(b, lenB, a, lenA, k, bStart, aStart);
        }

        if(lenA == 0) return b[bStart + k - 1];
        if(k == 1) return Math.min(a[aStart], b[bStart]);

        int i = Math.min(lenA, k/2);
        int j = Math.min(lenB, k/2);

        if(a[aStart + i - 1] < b[bStart + j - 1]){
            // discarding the numbers below i
            return findKth(a, lenA - i, b, lenB, k - i, aStart+i, bStart);
        } else {
            return findKth(a, lenA, b, lenB - j, k - j, aStart, bStart+j);
        }
    }
}
