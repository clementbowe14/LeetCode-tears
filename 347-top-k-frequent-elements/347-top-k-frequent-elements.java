class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        
        int [] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            buckets.add(new ArrayList<Integer>());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        buckets.add(new ArrayList<Integer>());
        
        for(int key : map.keySet()) {
            buckets.get(map.get(key)).add(key);
        }
        
        int idx = 0;
        for(int i = buckets.size() -1; i >= 0; i--){
            for(int j = 0; j < buckets.get(i).size(); j++){
                if(idx >= k)
                    break;
                ans[idx++] = buckets.get(i).get(j);
            }
        }
        
        return ans;
    }
}