class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();

        helper(n, 1, k, new ArrayList<>());

        return res;
    }

    public void helper(int n, int i, int k, List<Integer> ans){
        
        if(ans.size() == k){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int j = i; j <= n; j++){
            ans.add(j);
            helper(n, j+1, k, ans);
            ans.remove(ans.size() - 1);
        }
    }
}