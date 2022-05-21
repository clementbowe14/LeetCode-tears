class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins == null || coins.length == 0)
            return -1;
        
        int[][] dp = new int[coins.length][amount+1];
        
        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE-1);
      
        dp[0][0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            if(i >= coins[0])
                dp[0][i] = dp[0][i - coins[0]] == Integer.MAX_VALUE-1 ? Integer.MAX_VALUE-1: dp[0][i - coins[0]] + 1;
        }
        
        for(int i = 1; i < coins.length; i++){
            for(int j = 0; j <= amount; j++) {
                if(j >= coins[i]) {
                   int newValue = dp[i][j - coins[i]] == Integer.MAX_VALUE-1 ? Integer.MAX_VALUE-1: dp[i][j - coins[i]] + 1;
                    dp[i][j] = Math.min(dp[i-1][j], newValue);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[coins.length-1][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length-1][amount];
    }
}