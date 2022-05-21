class Solution {
    
    public int[][] coords = {{0,1},{1,0},{0,-1},{-1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE/2);
        }
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    dp[i][j] = 0;
                    queue.add(new int[]{i,j, 0});
                }
            }
        }
        
        while(!queue.isEmpty()) {
            
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            
            for(int i = 0; i < coords.length; i++) {
                
                int newRow = row + coords[i][0];
                int newCol = col + coords[i][1];
                int newSteps = 1 + steps;
                
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && dp[newRow][newCol] > newSteps){
                    dp[newRow][newCol] = newSteps;
                    queue.add(new int [] {newRow, newCol, newSteps});
                }
            }
        }
        
        return dp;
    }
}