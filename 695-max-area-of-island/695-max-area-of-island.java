class Solution {
    public int islandArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        int maxArea = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                islandArea = 0;
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(i,j, visited, grid, 0);
                    maxArea = Math.max(maxArea, islandArea);
                }
                visited[i][j] = true;
            }
        }
        return maxArea; 
    }
    public void dfs(int row, int col, boolean[][]visited,int[][] grid, int size){
        int M = grid.length;
        int N = grid[0].length;
        if(row >= M || row < 0 || col >= N || col < 0 || visited[row][col] || grid[row][col] == 0){
            return;
        }
        visited[row][col] = true;
        islandArea++;
        dfs(row-1,col, visited, grid, size); 
        dfs(row+1,col, visited, grid, size);
        dfs(row,col-1, visited, grid, size);
        dfs(row,col+1, visited, grid, size);
    }
}