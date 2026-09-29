class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(0, s, new ArrayList<String>());
        return res;
    }

    public void helper(int i, String s, ArrayList<String> set){
        if(i >= s.length()) {
            res.add(new ArrayList<>(set));
            return;
        };

        for(int j = i; j < s.length(); j++){
            if(isPali(s, i, j)){
                set.add(s.substring(i, j+1));
                helper(j+1, s, set);
                set.remove(set.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
