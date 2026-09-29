class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String code = getStringCode(s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public String getStringCode(String str){
        int[] code = new int[26];
        for(char c : str.toCharArray()){
            code[c-'a']++;
        }
        return Arrays.toString(code);
    }
}
