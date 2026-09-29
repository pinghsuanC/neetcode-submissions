class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){ return s.length(); }
        int l = 0, r = 1, max = 0;
        while(r < s.length()){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(l));
            while(r < s.length() && !set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(set.size(), max);
            l++;
            r=l+1;
        }
        return max;
    }
}
