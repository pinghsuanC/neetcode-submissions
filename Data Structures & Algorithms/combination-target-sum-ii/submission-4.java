class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // intuition: backracking, and skipping duplicates
        // sort the candidates first, helps with skipping duplicates
        // since sum = target, whenever we choose a number, we substract it from target
        // until target = 0, we have a hit
        // if target is < 0, return
        // if i is >= n, return   
        res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>());

        return res;
    }

    private void helper(int[] arr, int i, int target, ArrayList<Integer> set){
        if(target == 0){
            res.add(new ArrayList<>(set));
            return;
        }
        if(target < 0) return;
        if(i >= arr.length) return;

        for(int j = i; j < arr.length; j++){
            if(j > i && arr[j] == arr[j - 1]) continue;
            set.add(arr[j]);
            helper(arr, j+1, target - arr[j], set);
            set.remove(set.size() - 1);
        }

    }

}
