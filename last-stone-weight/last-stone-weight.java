class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length < 2) {
            return stones[0];
        }
        
        while(true) {
            
            Arrays.sort(stones);
            
            if(stones[stones.length-1] == 0 || stones[stones.length-2] <= 0) {
                return stones[stones.length-1];
            }
            
            int temp = stones[stones.length-1];
            stones[stones.length-1] = stones[stones.length-1] - stones[stones.length-2];
            stones[stones.length-2] = stones[stones.length-2] - temp;
        }
        
    }
}