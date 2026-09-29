class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int res = 0, l = 0, maxF = 0;
        for(int r = 0; r < s.length(); r++){
            counts.putIfAbsent(s.charAt(r), 0);
            counts.put(s.charAt(r), counts.get(s.charAt(r))+1);
            //if(counts.get(s.charAt(r)) < maxF) continue;
            maxF = Math.max(counts.get(s.charAt(r)), maxF);
            while((r - l + 1) - maxF > k){
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
