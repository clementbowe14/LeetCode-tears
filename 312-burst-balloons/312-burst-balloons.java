class Solution {
    public int maxCoins(int[] nums) {
        //dp[i][j], max coins from the index i to index
        int n = nums.length;
        int len = n+2;
        int [] a = new int[len];
        System.arraycopy(nums, 0, a, 1, n);
        a[len-1] = 1;
        a[0] = 1;
        int[][] dp = new int[len][len];
        
        //left index + gap = right index
        // 0, 1, 2
        for(int gap = 2; gap < len; gap++){
            for(int left = 0; left < len-gap; left++){
                int curr = 0;
                int right = left + gap;
                for(int i = left + 1; i < right; i++) {
                    curr = Math.max(curr, dp[left][i] + dp[i][right] + (a[left] * a[i] * a[right]));
                }
                dp[left][right] = curr;
            }
        }
        return dp[0][len-1];
    }
}