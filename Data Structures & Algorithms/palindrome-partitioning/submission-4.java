class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<String>());

        return res;
    }

    private void helper(String s, int l, List<String> set){
        if(l >= s.length()){
            res.add(new ArrayList<>(set));
            return;
        }
        for(int r = l; r < s.length(); r++){
            if(isPalindrom(s, l, r)) {
                set.add(s.substring(l, r+1));
                helper(s, r+1, set);
                set.remove(set.size() - 1);
            }
        }
    }


    private boolean isPalindrom(String s, int l, int r){
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
