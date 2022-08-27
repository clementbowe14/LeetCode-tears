class Solution {
  
    
    public int numEnclaves(int[][] grid) {
        
         int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) {
                    dfs(i, j, grid);
                }
            }
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void dfs(int row, int col, int [][] grid) {
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
            
            grid[row][col] = 0;
            
            dfs(row+1, col, grid);
            dfs(row-1, col, grid);
            dfs(row, col+1, grid);
            dfs(row, col-1, grid);
        }
    }
}