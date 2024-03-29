class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int key : map.keySet()){
            if((k > 0 && map.containsKey(key+k)) || (k == 0 && map.get(key) > 1)){
                count++;
            }
        }
        return count;
    }
}