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
        if(n == 1) return 1;

        while(pt < n){
            char tmp = chars[pt];

            pt++;
            int len = 1;
            while(pt < n && chars[pt] == chars[pt - 1]){
                len++;
                pt++;
            }
            
            // move k to the position to start recording length
            chars[k] = tmp;
            k++;
            if(len == 1) continue;
            String l = len + "";
            for(int i = 0; i < l.length(); i++){
                if(k >= n) return k;
                chars[k] = l.charAt(i);
                k++;
            }
        }

        return k;
    }
}