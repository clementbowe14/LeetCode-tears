class Solution {
    
    public int findJudge(int n, int[][] trust) {
        
        int [][] amountTrusted = new int[n+1][n+1];
        
        for(int i = 0; i < trust.length; i++) {
            amountTrusted[trust[i][0]][0]++;
            amountTrusted[trust[i][1]][1]++;
        }
        
        for(int i = 1; i < amountTrusted.length; i++) {
            if(amountTrusted[i][0] == 0 && amountTrusted[i][1] == n-1) {
                return i;
            }
        }
        
        return -1;
    }
}