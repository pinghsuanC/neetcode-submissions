class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, r=0, max=0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, r - l + 1);
            set.add(s.charAt(r));
            r++;
        }
        return max;
    }
}
