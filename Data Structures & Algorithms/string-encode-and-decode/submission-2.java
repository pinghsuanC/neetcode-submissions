class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder(str);
        ArrayList<String> strs = new ArrayList<String>();
        for(int i = 0; i<str.length(); i++){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != '#' && i < str.length()){
                cur.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(cur.toString());
            String token = sb.substring(i+1, i+1+length);
            strs.add(token);
            i = i + length;
        }

        return strs;
    }
}
