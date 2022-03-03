class Solution {
    public int numIslands(char[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        boolean[][]visited = new boolean[grid.length][grid[0].length];
        int numIslands = 0; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(!visited[i][j] && grid[i][j] =='1'){
                    numIslands++;
                    dfs(i, j, visited, grid, m, n);
                }
                visited[i][j] = true;
            }
        }
        return numIslands;
    }
    public void dfs(int row, int col, boolean[][] visited, char[][] grid, int endRow, int endCol){
        if(row >= endRow || row < 0 || col >= endCol || col < 0 || visited[row][col]
          || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true; 
        
        dfs(row+1, col, visited, grid, endRow, endCol);
        dfs(row-1, col, visited, grid, endRow, endCol);
        dfs(row, col+1, visited, grid, endRow, endCol);
        dfs(row, col-1, visited, grid, endRow, endCol);
        
    }
}