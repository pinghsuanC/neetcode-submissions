class Solution {
    public boolean lemonadeChange(int[] bills) {
        /*
        each lemonade costs $5
        customer pay with $5, $10 and $20
        must provide correct change
        note that ith is sequential, so at one point you must have sufficient notes to pay
        use counters (just a hunch... greedy is tricky)
        */

        if(bills.length == 0) return true;
        if(bills[0] != 5) return false; // first one has to be 5

        int count5 = 0, count10 = 0;
        for(int b : bills){
            if(b==5) {
                count5++;
            } else if(b==10) {
                count10++;
                count5--;
            } else if(b==20){
                if(count10 > 0){
                    count10--;
                    count5--;
                } else {
                    count5-=3;
                }
            }

            if(count10 < 0 || count5 < 0) return false;
        }

        return true;
    }
}