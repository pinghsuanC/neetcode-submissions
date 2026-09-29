class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> setT = new HashMap<>();
        HashMap<Character, Integer> setS = new HashMap<>();
        String res = "";

        for(int i = 0; i < t.length(); i++){
            setT.putIfAbsent(t.charAt(i), 0);
            setT.put(t.charAt(i), setT.get(t.charAt(i))+1);

            setS.putIfAbsent(s.charAt(i), 0);
            setS.put(s.charAt(i), setS.get(s.charAt(i))+1);
        }

        if(validContains(setS, setT)) return s.substring(0, t.length());
        if(s.length() == t.length()) return "";

        int l = 0, r = t.length();
        while(r < s.length()){
            setS.putIfAbsent(s.charAt(r), 0);
            setS.put(s.charAt(r), setS.get(s.charAt(r)) + 1);
            if(!validContains(setS, setT)) { 
                r++;
                continue;
            }
            // now we have a hit, shrink l by removing elements, update counts
            while(validContains(setS, setT)){
                setS.put(s.charAt(l), setS.get(s.charAt(l))-1);
                l++;
            }
            String sub = s.substring(l - 1, r + 1);
            if("".equals(res) || sub.length() < res.length()) res = sub;
            r++;
        }

        return res;
    }

    public boolean validContains(HashMap<Character, Integer> setS, HashMap<Character, Integer> setT){
        // specific helper: return true if all element of T counts in setS is >= element counts in setT
        for(char c : setT.keySet()){
            if(setS.get(c) == null) return false;
            if(setS.get(c) < setT.get(c)) return false;
        }
        return true;
    }
}
