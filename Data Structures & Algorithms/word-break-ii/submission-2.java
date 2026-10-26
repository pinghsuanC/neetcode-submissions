class Solution {
    List<String> wordDictGlobal;
    Map<Integer, List<String>> dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictGlobal = wordDict;
        dp = new HashMap<>();
        return helper(s, 0);
    }

    public List<String> helper(String s, int i){
        if(i >= s.length()) return Arrays.asList("");
        if(dp.containsKey(i)) return dp.get(i);

         List<String> res = new ArrayList<>();
        for(int j = i; j < s.length(); j++){
            String w = s.substring(i, j+1);
            if(!wordDictGlobal.contains(w)) continue;
            List<String> strings = helper(s, j + 1);
            for (String substr : strings) {
                String sentence = w;
                if (!substr.isEmpty()) sentence += " " + substr;
                res.add(sentence);
            }
        }
        dp.put(i, res);
        return res;
    }
}