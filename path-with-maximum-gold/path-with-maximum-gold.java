class Solution {
    int maxPath = 0;
    public int getMaximumGold(int[][] grid) {
        //keeps track of the max path as well as previously found results.
        
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    boolean[][] visited = new boolean[m][n];
                    findPath(grid, visited, i, j, m, n, 0);
                }
            }
        }
        return maxPath;
    }
    
    public void findPath(int[][] grid, boolean[][] visited, int row, int col, int maxRow, int maxCol, int currentPath){
        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || visited[row][col]|| grid[row][col] == 0){
            maxPath = Math.max(maxPath, currentPath);
            return;
        }
        
        visited[row][col] = true;
        
        findPath(grid, visited, row-1, col, maxRow, maxCol, currentPath+grid[row][col]);
        findPath(grid, visited, row+1, col, maxRow, maxCol, currentPath+grid[row][col]);
        findPath(grid, visited, row, col-1, maxRow, maxCol, currentPath+grid[row][col]);
        findPath(grid, visited, row, col+1, maxRow, maxCol, currentPath+grid[row][col]);
        
        visited[row][col] = false;
    }
}