class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        Map<String, int[]> map = new HashMap<>();
        for(String word : strs) {
            int zeros = 0;
            int ones = 0;
            for(char letter : word.toCharArray()) {
                if(letter == '0'){
                    zeros++;
                } else {
                    ones++;
                }
            }
            map.put(word, new int[] {zeros, ones});
        }

        int maxElements = 1;
        
        for(String word : strs) {
           int totalZeros = map.get(word)[0];
           int totalOnes = map.get(word)[1];
            for(int i = m; i >= totalZeros; i--){
                for(int j = n; j >= totalOnes; j--) {
                    if(i >= totalZeros && j >= totalOnes) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - totalZeros][j-totalOnes]);
                    } 
                }
            }
            maxElements++;
        }
        
        
    
        
        return dp[m][n];
    }
}