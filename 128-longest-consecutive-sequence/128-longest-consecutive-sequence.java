class Solution {
    static class UF {
        private int [] id;
        private int [] size;
        
        public UF(int n) {
            this.id = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int index) {
            if(index == id[index])
                return index;
            
            return find(id[index]);
        }
        
        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            id[parentX] = parentY;
            size[parentY] += size[parentX];
        }
        
        public int computeLargestSequence() {
            int ans = 0;
            for(int i = 0; i < size.length; i++) {
                if(id[i] == i){
                    ans = Math.max(ans, size[i]);
                }
            }
            return ans;
        }
    }
    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                
                if(map.containsKey(nums[i]-1)) {
                    uf.union(i, map.get(nums[i]-1));
                }
                
                if(map.containsKey(nums[i]+1)){
                    uf.union(i, map.get(nums[i]+ 1));
                }
                
                map.put(nums[i], i);
            } else {
                continue;
            }
        }
        
        return uf.computeLargestSequence();
    }
}