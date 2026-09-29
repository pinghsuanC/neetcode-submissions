class Solution {

    Map<Integer, Integer> dp;
    public int numDecodings(String s) {
        dp = new HashMap<>();
        dp.put(s.length(), 1);
        return helper(s, 0);
    }

    public int helper(String s, int i){
        if(dp.containsKey(i)) return dp.get(i);
        if(s.charAt(i) == '0') return 0;

        int res = helper(s, i+1);
        if(i + 1 < s.length() && 
            (s.charAt(i) == '1' || s.charAt(i) == '2' && 
            s.charAt(i+1) < '7')){
            res += helper(s, i+2);
        }
        dp.put(i, res);

        return res;
    }
}
