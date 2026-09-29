class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // intuition: use priority queue to handle the top-k
        // this time the sorting needs to be done on the count, instead of the value
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        Set<Integer> uniques = new HashSet<>();

        for(int n : nums){
            uniques.add(n);
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n)+1);
        }

        for(int i : uniques){
            queue.offer(i);
            if(queue.size() > k) queue.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            res[i] = queue.poll();
            i++;
        }

        return res;

    }
}
