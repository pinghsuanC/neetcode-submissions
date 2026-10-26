class Solution {
    List<String> wordDictGlobal;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictGlobal = wordDict;
        res = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return res;
    }

    public void helper(String s, int i, List<String> sentence){
        if(i >= s.length()){
            res.add(String.join(" ", sentence));
            return;
        }

        for(int j = i; j < s.length(); j++){
            String w = s.substring(i, j+1);
            if(wordDictGlobal.contains(w)){
                sentence.add(w);
                helper(s, j + 1, sentence);
                sentence.remove(sentence.size() - 1);
            }
        }
    }
}