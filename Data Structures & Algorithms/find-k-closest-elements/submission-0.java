class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        List<int[]> arrDiff = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) arrDiff.add(new int[]{arr[i], Math.abs(arr[i] - x)});
        Collections.sort(arrDiff, (a, b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        for(int i = 0; i < k; i++) res.add(arrDiff.get(i)[0]);
        Collections.sort(res);

        return res;
    }
}