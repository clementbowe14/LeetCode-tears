class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++){
            for(int j = 0; j < i-1; j++){
                dp[i] = Math.max(nums[i] + dp[j], dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}