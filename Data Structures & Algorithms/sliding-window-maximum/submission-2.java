class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        while(r < nums.length){
            int ele = nums[r];
            while(!queue.isEmpty() && nums[queue.peekLast()] < ele){
                queue.removeLast();
            }
            queue.offer(r);

            if(l > queue.peekFirst()){
                queue.removeFirst();
            }

            if(r + 1 >= k){
                res[l] = nums[queue.peekFirst()];
                l++;
            }

            r++;
        }
        return res;
    }
}
