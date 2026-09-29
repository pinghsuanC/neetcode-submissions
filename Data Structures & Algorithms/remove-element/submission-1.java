class Solution {
    public int removeElement(int[] nums, int val) {
        /** intuition: 
            - track the last index r = len - 1
            - track the # of vals we encountered

            - move the last index to the last-most position where nums[r] is not val, count++
            - from head of nums i = 0 to i <= r - 1
                -> if nums[i] == val, swal nums[r] and nums[i], count++
                    -> r-- until nums[r] is not val, count++
        **/

        int n = nums.length, r = n - 1, l = 0;

        while(r >= 0 && nums[r] == val){
            r--;
        }

        while(l <= r && l < n){
            if(nums[l] == val){
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
                l++;
                while(r >= 0 && nums[r] == val){
                    r--;
                }
                continue;
            }
            l++;
        }

        return l;
    }
}