class Solution {
    
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i :nums){
            map.put(i, new HashSet<>());
        }
        
        for(int i = 0; i < nums.length-1; i++){
            
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            
            while(left <= right){
                int mid = (left + right)/2;
                if(nums[mid]-nums[i] < k) {
                    // System.out.println("I'm too small " + (nums[i] - nums[mid]));
                    left = mid+1;
                } else {
                    // System.out.println("I'm too large or equal " + (nums[mid] - nums[mid]));
                    if(nums[mid]-nums[i] == k && map.get(nums[i]).add(nums[mid])){
                        count++;
                    }
                    right = mid-1;
                }
            }
        }
        
        return count;
    }
}