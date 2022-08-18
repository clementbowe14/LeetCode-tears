class Solution {
    public int deleteAndEarn(int[] nums) {
        int [] dp = new int[10001];
        int take = 0;
        int skip = 0;
        int max = 0;
        for(int num : nums){
            dp[num] += num;
            max = Math.max(num, max);
        }
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        }
        return dp[10000];
    }
}