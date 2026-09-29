class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        List<List<String>> l = new ArrayList<List<String>>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String code = new String(chars);
            res.putIfAbsent(code, new ArrayList<>());
            res.get(code).add(s);
        }
        return res.values().stream().collect(Collectors.toList());
    }
}
