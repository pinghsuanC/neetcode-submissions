class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] a = helper(s);
        int[] b = helper(t);
        for(int i = 0; i < 26; i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }


    public int[] helper(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}
