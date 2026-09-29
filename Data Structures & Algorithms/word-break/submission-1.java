class Solution {
    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        // brute force
        HashSet<String> wordSet = new HashSet<>(wordDict);
        map = new HashMap<>();
        map.put(s.length(), true);

        boolean res = helper(s, wordSet, 0);

        return res;
    }

    public boolean helper(String s, HashSet<String> wordSet, int i){
        if(map.containsKey(i)) return map.get(i);

        for(String w : wordSet){
            if(i + w.length() <= s.length() 
                && s.substring(i, i+w.length()).equals(w)){
                if(helper(s, wordSet, i + w.length())){
                    map.put(i, true);
                    return true;
                }
            }
        }

        map.put(i, false);
        return false;
    }
}
