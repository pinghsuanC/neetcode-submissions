/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        /*
        intuition:
        -> with mountainArrays, 0 < i < arr.length - 1, so i can't be 2 ends
        -> want: min index where mountainArray.get(index) == target, -1 if doesn't exist
        
        --> this just looks like the rotated array problem
        --> find the mountain top can be very helpful in finding the indices in half
            --> cause' there are 2 possible places, 1 in left half, 1 in right half
            --> concern is that we only have 100 get calls
            --> but will try this first
        */
        int len = mountainArr.length();
        int l = 0, r = len - 1, minIndex = len;
        if(mountainArr.get(l) == target) return l; // can't go lower

        int topIndex = len;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid - 1 < 0 || mid + 1 > len) break;
            int val1 = mountainArr.get(mid - 1), val2 = mountainArr.get(mid), val3 = mountainArr.get(mid + 1);
            if(val1 < val2 && val2 > val3){
                 topIndex = mid;
                 break;
            }
            if(val1 > val2){
                r = mid;
            } else {
                l = mid;
            }
        }

        // so [0 ~ top index] & [topIndex ~ len - 1] each half, do left first, and then if not found, do right.
        
        l = 0;
        r = topIndex;
        while(l <= r){
            int mid = l + (r - l) /2;
            int midVal = mountainArr.get(mid);
            if(midVal == target) {
                minIndex = Math.min(minIndex, mid);
                r = mid - 1;
            } else if(midVal < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(minIndex != len) return minIndex;

        l = topIndex;
        r = len - 1;
        while(l <= r){
            int mid = l + (r - l) /2;
            int midVal = mountainArr.get(mid);
            if(midVal == target) {
                return Math.min(minIndex, mid);
            } else if(midVal < target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if(minIndex == len) return -1;
        return minIndex;
    }


}