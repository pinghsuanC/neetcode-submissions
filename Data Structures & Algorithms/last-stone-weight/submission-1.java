class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
       for(int k : stones){
           q.offer(k);
       }

       while(q.size() > 1) {
          int x = q.poll();
          int y = q.poll();
          int r = Math.abs(x - y);
          if(r>0) q.offer(r);
       }

       if(q.isEmpty()) return 0;
       return q.poll();
    }
}
