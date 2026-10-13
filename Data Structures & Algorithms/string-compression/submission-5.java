class Solution {
    public int compress(char[] chars) {
        /*
        -> pointer to store where we are now
        -> pointer to go through chars
            -> find substring if tehre are consecutive chars of the same value
        -> given length, need to break it by / 10 and % 10

        k = length of the compressed string
        */

        int pt = 0, n = chars.length, k = 0;

        while(pt < n){

            char tmp = chars[pt];
            int len = 0;
            while(pt < n && chars[pt] == tmp){
                len++;
                pt++;
            }
            
            // record the char
            chars[k] = tmp;
            k++;

            // record the length
            if(len == 1) continue;
            for(char c : (len + "").toCharArray()){
                if(k >= n) return k;
                chars[k] = c;
                k++;
            }
        }

        return k;
    }
}