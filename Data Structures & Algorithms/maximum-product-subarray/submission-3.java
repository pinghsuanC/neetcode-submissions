class Solution {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        List<List<Integer>> sublists = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for(int n : nums){
            res = Math.max(res, n);
            if(n != 0){
                cur.add(n);
                continue;
            }

            if(!cur.isEmpty()){
                sublists.add(cur);
                cur = new ArrayList<>();
            }
        }
        if(!cur.isEmpty()) sublists.add(cur);

        for(List<Integer> sub : sublists){
            int negs = 0;
            for(int n : sub) if(n < 0) negs++;

            int need = (negs %2 == 0) ? negs : negs - 1,
                negCounts = 0,
                prod = 1;
            for(int r = 0, l = 0; r < sub.size(); r++){
                prod *= sub.get(r);
                if(sub.get(r) < 0){
                    negCounts++;
                    while(negCounts > need && l < r){
                        prod /= sub.get(l);
                        if(sub.get(l) < 0) negCounts--;
                        l++;
                    }
                }
                res = Math.max(res, prod);
            }
        }

        return res;
    }

}
