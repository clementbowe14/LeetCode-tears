class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int curr = 0;
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(map.containsKey(nums[i])){
                while(c <= map.get(nums[i]))
                    curr -= nums[c++];
            }
            map.put(nums[i], i);
            max = Math.max(curr, max);
        }
        return max;
    }
}