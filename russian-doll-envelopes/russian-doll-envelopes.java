class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2) {
            return 1;
        }
        
        Arrays.sort(envelopes, (a, b) -> a[0]*a[1] - b[0]*b[1]);
        int [] dp = new int[envelopes.length];
        dp[0] = 1;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 1; i < envelopes.length; i++) {
            int currentWidth = envelopes[i][0];
            int currentHeight = envelopes[i][1];
            dp[i] = 1;
            
            for(int j = 0; j < i; j++) {
                int bWidth = envelopes[j][0];
                int bHeight = envelopes[j][1];
                
                if(currentWidth > bWidth && currentHeight > bHeight) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}