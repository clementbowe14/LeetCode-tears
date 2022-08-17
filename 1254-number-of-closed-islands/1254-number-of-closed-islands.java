class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && !visited[i][j] && dfs(i, j, grid, visited)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public boolean dfs(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        } 
        
        if(grid[row][col] == 1 || visited[row][col]) {
            return true;
        }
        
        visited[row][col] = true;
        
        boolean up = dfs(row-1, col, grid, visited);
        boolean down = dfs(row+1, col, grid, visited);
        boolean left = dfs(row, col-1, grid, visited);
        boolean right = dfs(row, col+1, grid, visited);
        
        return up && down && left && right;

    }
}