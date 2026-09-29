class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for(int n : nums) set.add(n);

        for(int n : set){
            if(set.contains(n-1)) continue;
            if(!set.contains(n+1)) continue;
            int len = 1;
            int k = n;
            while(set.contains(k+1)){
                len++;
                k++;
            }
            max = Math.max(len, max);
        }
        
        return max;
    }
}
