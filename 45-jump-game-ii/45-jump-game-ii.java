class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        
        int currentMaxJump = 0;
        int previousJump = 0;
        int res = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            currentMaxJump = Math.max(currentMaxJump, nums[i] + i);
            if(i == previousJump){
                res++;
                previousJump = currentMaxJump;
            }
            
            if(previousJump >= nums.length-1)
                return res;
        }
        
        return res;
    }
}