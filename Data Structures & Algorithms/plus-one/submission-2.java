class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;
        while(i >= 0){
            int sum = digits[i] + carry;
            digits[i] = sum;
            if(carry > 0) carry--;
            if(sum >= 10){
                carry = 1;
                digits[i]-=10;
            }
            i--;
        }

        if(carry > 0){
            int[] newDigits = new int[digits.length+1];
            for(int k = digits.length-1; k > 0; k--){
                newDigits[k] = digits[k];
            }
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }
}
