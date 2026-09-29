class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    private void helper(String s, int i, List<String> set){
        if(i >= s.length()){
            res.add(new ArrayList<>(set));
            return;
        }

        for(int j = i; j < s.length(); j++){
            if(isPalindrom(s.substring(i, j+1))){
                set.add(s.substring(i, j+1));
                helper(s, j+1, set);
                set.remove(set.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s){
        int l = 0, r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
