class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        intuition
        - smaller negative numbers gets larger differences
        - larger positive numbers gets larger differences
        - if we have n in arr that == x, it will be 0

        - sort the arr -> small positive on the left and larger positve on the right, and we now is firm that arr[l] <= arr[r]
        - start from right side, have a window of l and r, 
        - expand to the left side when diff is smaller
            - check if l - r + 1 == k.
            - if size smaller than k just expand and continue to next cycle
            - else
                - compare arr[r] with arr[l]. if |arr[l] - x| <= |arr[r] - x|, move the right pointer left while move left pointer
               - do this until we exhause l, or |arr[l] - x| > |arr[r] - x|
        */

        int n = arr.length, l = n - 1, r = n - 1;
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        while(l > 0){
            if(r - l + 1 < k){
                l--; // make sure we have a window of size k
                continue;
            }

            l--;
            if(Math.abs(x - arr[l]) <= Math.abs(x - arr[r])){
                r--;
            } else {
                l++;
                break;
            }

        }

        for(int i = l; i <= r; i++) res.add(arr[i]);
        return res;
    }
}