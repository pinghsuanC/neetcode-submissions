class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){ return s.length(); }
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
