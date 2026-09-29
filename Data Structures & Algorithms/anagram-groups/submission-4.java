class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();

        for(String str : strs){
            Map<Integer, Integer> freq = new HashMap();
            for(int i = 0; i < str.length(); i++){
                int code = Character.getNumericValue(str.charAt(i));
                if(freq.get(code) == null){
                    freq.put(code, 0);
                }
                freq.put(code, freq.get(code)+1);
            }
            System.out.println(freq);
            String uniqueKey = "";
            ArrayList<Integer> keys = new ArrayList<>(freq.keySet());
            Collections.sort(keys);
            for(Integer k : keys){
                uniqueKey+=(k + "" + freq.get(k) + "$$");
            }
            if(map.get(uniqueKey) == null){
                map.put(uniqueKey, new ArrayList<>());
            }
            System.out.println(uniqueKey + " " + str);
            map.get(uniqueKey).add(str);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}
