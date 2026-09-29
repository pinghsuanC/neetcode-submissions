class Solution {

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder res = new StringBuilder();
        for(String s : strs){
            res.append(s.length()).append("|").append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        if("".equals(str)) return res;

        // manually increment i for the next starting point
        for(int i = 0; i < str.length();){
            // first to extract the length of the string, it's length + ||
            // note length can be multiple digits
            int l = i, r = i+1;
            while(r < str.length() && str.charAt(r) != '|') r++;
            int len = Integer.parseInt(str.substring(l, r));
            res.add(str.substring(r+1, r+len+1));
            i = r + len + 1;
        }

        return res;
    }
}
