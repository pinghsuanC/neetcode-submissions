class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for(int[] trip : triplets){
            boolean flag = false;
            for(int i = 0; i < 3; i++){
                if(trip[i] > target[i]) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            for(int i = 0; i < 3; i++){
                if(trip[i] == target[i]) good.add(i);
            }
        }

        return good.size() == 3;
    }
}
