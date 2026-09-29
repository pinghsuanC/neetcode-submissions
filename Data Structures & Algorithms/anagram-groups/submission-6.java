class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        List<List<String>> l = new ArrayList<List<String>>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String code = "";
            for(char c : chars){
                code+=("#" + c);
            }
            if(res.containsKey(code)){
                res.get(code).add(s);
            } else {
                List<String> arr = new ArrayList<String>();
                arr.add(s);
                res.put(code, arr);
            }
        }
        return res.values().stream().collect(Collectors.toList());
    }
}
