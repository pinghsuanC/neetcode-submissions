class Solution {
    public int lengthOfLongestSubstring(String s) {
        // intuition: 
        // build a window with l = 0, r = 0
        // use a set to track what we have in a substring
        // when we encounter a met char at r position, move l until there is no dup
        if(s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 1, max = Integer.MIN_VALUE;
        set.add(s.charAt(0));
        while(r < s.length()){
            while(l <= r && set.contains(s.charAt(r))){
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
