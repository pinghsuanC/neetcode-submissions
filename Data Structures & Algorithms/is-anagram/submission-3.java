class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> freq = new HashMap<>();
        if(s.length() != t.length()){ return false; }
        for(int i =0; i<s.length(); i++){
            int c = Character.getNumericValue(s.charAt(i));
            if(freq.get(c) == null){
                freq.put(c, 0);
            }
            freq.put(c, freq.get(c)+1);
        }
        for(int i =0; i<t.length(); i++){
            int c = Character.getNumericValue(t.charAt(i));
            if(freq.get(c) == null){
                return false;
            }
            freq.put(c, freq.get(c)-1);
            if(freq.get(c) < 0){
                return false;
            }
        }
        return true;
    }
}
