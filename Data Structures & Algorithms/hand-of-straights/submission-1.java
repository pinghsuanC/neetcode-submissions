class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for(int h : hand) count.put(h, count.getOrDefault(h, 0) + 1);

        Arrays.sort(hand);
        for(int i = 0; i < hand.length; i++){
            if(count.get(hand[i]) == 0) continue;
            for(int k = hand[i]; k < hand[i] + groupSize; k++){
                if(!count.containsKey(k) || count.get(k) == 0) return false;
                count.put(k, count.get(k) - 1);
            }
        }

        return true;
    }
}
