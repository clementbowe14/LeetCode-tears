class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for(int i = 0; i < grid1.length; i++) {
            for(int j = 0; j < grid1[0].length; j++) {
                if(grid2[i][j] == 1 && dfs(i, j, grid1, grid2)){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(int row, int col, int[][] grid1 , int[][] grid2) {
        if(row < 0 || row >= grid2.length || col < 0 || col >= grid2[0].length || grid2[row][col] == 0) {
            return true;
        }
        
        if(grid2[row][col] == 1 && grid1[row][col] == 0) {
            return false;
        }
        
        grid2[row][col] = 0;
        
        boolean up = dfs(row-1, col, grid1, grid2);
        boolean down = dfs(row+1, col, grid1, grid2);
        boolean left = dfs(row, col-1, grid1, grid2);
        boolean right = dfs(row, col+1, grid1, grid2);
        
        return up && down && left && right;
    }
}