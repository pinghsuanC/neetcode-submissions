class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> res = new HashSet<Integer>();
        HashMap<Integer, HashSet<Integer>> mapMinus1 = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, HashSet<Integer>> mapPlus1 = new HashMap<Integer, HashSet<Integer>>();
        if(nums.length == 1){ return 1;}
        if(nums.length == 0){ return 0;}

        for(int n : nums){
            if(mapMinus1.get(n-1) != null){
                mapMinus1.get(n-1).add(n);
            } else {
                HashSet<Integer> newSet = (new HashSet<Integer>());
                newSet.add(n);
                mapMinus1.put(n-1, newSet);
            }

            if(mapPlus1.get(n+1) != null){
                mapPlus1.get(n+1).add(n);
            }else {
                HashSet<Integer> newSet = (new HashSet<Integer>());
                newSet.add(n);
                mapPlus1.put(n+1, newSet);
            }
        }
        
        int maxLen = Integer.MIN_VALUE;
        for(int n : nums){
            int len = 0;
            int targetMin = n-1;
            int targetMax = n+1;
            HashSet<Integer> seq = new HashSet<Integer>();
            while(mapMinus1.get(targetMin) != null){
                HashSet<Integer> valids = mapMinus1.get(targetMin);
                seq.addAll(valids);
                len++;
                targetMin--;
            }
            while(mapPlus1.get(targetMax) != null){
                HashSet<Integer> valids = mapPlus1.get(targetMax);
                seq.addAll(valids);
                len++;
                targetMax++;
            }
            maxLen = Math.max(maxLen, seq.size());
        }

        return maxLen;
    }
}
