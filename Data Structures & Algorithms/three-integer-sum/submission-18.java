class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Intuition:
        // use two-pointer, l, and r
        // sort the nums so that it's min to max
        // for each position k, 
        //      check if k is repetitive, move pointer k all the way until it's a different number (note that we need to allow the first pass for any number)
        //      l = k + 1, r = nums.length - 1
        //      if nums[l] + nums[r] = 0 - k, add it to the results
        //          if we've got a hit, move the left pointer all the way to a point until it's a different number          
        //      if total > target, then move the right pointer down
        //      if total < target, then move the left pointer up
        // return the result

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length; k++){
            if(k > 0 && nums[k] == nums[k-1]) continue;

            int l = k+1, r = nums.length - 1;
            while(l < r){
                int total = nums[l] + nums[r] + nums[k];
                if(total > 0){
                    r--;
                } else if (total < 0){
                    l++;
                } else {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    arr.add(nums[k]);
                    l++;
                    r--;
                    res.add(arr);

                    while(l > 0 && l < r && nums[l] == nums[l-1]) {
                        l++;
                        continue;
                    }
                }
                
            }
        }

        return res;

    }
}
