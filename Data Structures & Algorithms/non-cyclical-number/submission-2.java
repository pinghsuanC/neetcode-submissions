class Solution {
    public boolean isHappy(int n) {
        char[] chars = (n+"").toCharArray();
        Set<Integer> res = new HashSet<>();
        int sum = 0;
        
        while(!res.contains(sum)){
            for(char c : chars){
                sum += (c - '0')*(c - '0');
            }
            if(res.contains(sum)) break;
            res.add(sum);
            chars = (sum + "").toCharArray();
            sum = 0;
        }

        return res.contains(1);
    }
}
