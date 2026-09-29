class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int l = 0, r = 1;
        Set<Character> set = new HashSet<>();
        int max = 1;
        set.add(s.charAt(l));
        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                max = Math.max(max, r - l + 1);
                r++;
                continue;
            }
            while(set.contains(s.charAt(r))){
                char c = s.charAt(l);
                set.remove(c);
                l++;
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }

    
}
