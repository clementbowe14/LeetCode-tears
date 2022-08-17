class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int m = grid.length-1;
        int n = grid[0].length-1;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            if(grid[i][0] == 0 && !visited[i][0]) {
                dfs(i, 0, grid, visited);
            }
            if(grid[i][n] == 0 && !visited[i][n]){
                dfs(i, n, grid, visited);
            }
        }
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 0 && !visited[0][i]){
                dfs(0, i, grid, visited);
            }
            if(grid[m][i] == 0 && !visited[m][i]){
                dfs(m, i, grid, visited);
            }
        }
        for(int i = 1; i < grid.length-1; i++){
            for(int j = 1; j < grid[0].length-1; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    dfs(i, j, grid, visited);
                    res++;
                }
            }
        }
        return res;
    }
    
    public void dfs(int row, int col, int[][] grid, boolean[][] visited){
        if(row < 0 || row > grid.length-1 || col < 0 || col > grid[0].length-1 || visited[row][col] || grid[row][col] == 1){
            return;
        }
        visited[row][col] = true;
        int [][] coord = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < coord.length; i++){
            int newRow = row + coord[i][0];
            int newCol = col + coord[i][1];
            dfs(newRow, newCol, grid, visited);
        }
    }
}