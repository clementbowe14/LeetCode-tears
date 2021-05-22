class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] prefixMax = new int[nums.length];
        int[] prefixMin = new int[nums.length];
        prefixMin[0] = Math.min(nums[0], 1);
        prefixMax[0] = Math.max(nums[0], 1);
        int ans = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int pMax = prefixMax[i-1]*nums[i];
            int pMin = prefixMin[i-1]*nums[i];
            System.out.println(prefixMax[i-1]);
            int max = Math.max(pMax, nums[i]);
            max = Math.max(max, pMin);
            int min = Math.min(pMax, pMin);
            min = Math.min(min, nums[i]);
            
            prefixMax[i] = max;
            prefixMin[i] = min;
            
          
            ans = Math.max(prefixMax[i], ans);
        }
        return ans;
    }
}