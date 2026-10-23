class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        List<Integer> res = new ArrayList<>();
        for(int n : map.keySet()){
            if(map.get(n) > len / 3) res.add(n);
        }

        return res;
    }
}