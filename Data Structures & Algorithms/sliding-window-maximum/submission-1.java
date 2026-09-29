class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = k;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < r; i++){
            maxHeap.offer(nums[i]);
        }
        if(maxHeap.isEmpty()) return nums;
        ArrayList<Integer> arr = new ArrayList<>();
        int max = maxHeap.peek();
        arr.add(max);

        while(r < nums.length){
            int removed = nums[l];
            int added = nums[r];
            if(removed < maxHeap.peek()){
                maxHeap.remove(removed);
            } else {
                maxHeap.poll();
                if(!maxHeap.isEmpty()) max = maxHeap.peek();
                else max = Integer.MIN_VALUE;
            }
            maxHeap.offer(added);
            max = maxHeap.peek();
            arr.add(max);
            l++;
            r++;
        }

        int[] res = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            res[i] = arr.get(i);
        }

        return res;
    }
}
