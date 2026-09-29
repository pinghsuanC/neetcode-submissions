class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String s : strs){
            encoded+=(s.length() + "#" + s);
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<String>();
        System.out.println(str);
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
