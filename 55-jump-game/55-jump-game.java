class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        
        int prevPos = 0;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxIndex >= i){
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return maxIndex >= nums.length-1;
    }
}