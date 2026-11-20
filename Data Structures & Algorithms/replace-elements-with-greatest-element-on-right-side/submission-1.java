class Solution {
    public int[] replaceElements(int[] arr) {
        
        int tmp = -1;
        for(int i = arr.length - 1; i >=0; i--){
            int cur = arr[i];
            arr[i] = tmp;
            tmp = Math.max(cur, arr[i]);
        }

        return arr;
    }
}