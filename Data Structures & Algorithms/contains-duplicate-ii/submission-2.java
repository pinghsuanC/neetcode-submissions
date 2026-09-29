class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return false;

        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) arr.add(new int[]{nums[i], i});
        arr.sort((a, b) -> Integer.compare(a[0], b[0]));
        int r = 0;
        
        // check each same-value group
        while(r <= n-1){
            int l = r;
            r++;
            while(r <= n-1 && arr.get(r-1)[0] == arr.get(r)[0]) {
                for(int i = l; i < r; i++){
                    int diff = Math.abs(arr.get(r)[1] - arr.get(i)[1]);
                    if(diff <= k) return true;
                }
                r++;
            }
            
        }
        return false;
    }
}