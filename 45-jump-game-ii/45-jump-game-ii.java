class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int [] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                boolean canJump = nums[j] + j >= i;
                if(canJump){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length-1];
    }
}