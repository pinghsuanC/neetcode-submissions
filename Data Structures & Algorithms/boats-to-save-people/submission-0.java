class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
        notes
        - people[i] = weight of ith
        - infinite # of boats, each carry limit weights
            - each boat carries at most 2 ppl (0, 1, 2 ppl)
            - max carry = limit

        - Find minimun # of boats

        -> note that in order to minimize # boats, have to maximize each load
        -> pairs:
            - 1 person if weight == limit
            - (heavy + light) < limit, have 2 ppl
        */

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int l = 0, r = people.length - 1;
        int num = 0;
        while(l <= r){
            // check if larger one + smaller one is over limit
            if(l == r){
                // 1 person left, have to take one
                num++;
                break;
            }
            if(people[r] + people[l] > limit){
                // can only take 1 larger one
                num++;
                r--;
            } else {
                // can take 2
                num++;
                r--;
                l++;
            }
        }

        return num;
    }

    
}