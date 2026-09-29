class Solution {
    public List<Integer> partitionLabels(String s) {
        Stack<int[]> stack = new Stack<>();
        Map<Character, int[]> check = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!check.containsKey(c)) check.put(c, new int[]{i, i+1});
            
            check.get(c)[1] = Math.max(check.get(c)[1], i+1);
        }

        for(Character c : check.keySet()) minHeap.offer(check.get(c));

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            while(!minHeap.isEmpty() && cur[1] > minHeap.peek()[0]){
                int[] mix = minHeap.poll();
                cur[1] = Math.max(cur[1], mix[1]);
            }
            res.add(cur[1] - cur[0]);
        }
        
        return res;
    }
}
