class Solution {
    
    //find the starting square
    //then perform a dfs to find valid paths to the end location
    //once location is found while backtracking store the
    int validPaths = 0;
    int emptyCells = 1;
    public int [] findStartingPoint(int [][] grid){
        if(grid == null || grid.length == 0){
            return new int [] {-1,-1};
        }
        int [] startingLocation = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    emptyCells++;
               else if(grid[i][j] == 1){
                    startingLocation[0] = i;
                    startingLocation[1] = j;
                }
            }
        }
        
        return startingLocation;
    }
    
    public boolean validLocation(int[][] grid, int currentRow, int currentCol, int rowBound, int colBound, boolean[][] visited){
        if(currentRow >= rowBound || currentRow < 0 || currentCol >= colBound || currentCol < 0 || grid[currentRow][currentCol] == -1 ||visited[currentRow][currentCol]){
            return false;
        }
        
        return true; 
    }
    public int uniquePathsIII(int[][] grid) { 
        int M = grid.length;
        int N = grid[0].length;
        boolean [][] visited = new boolean[M][N];
        int [] startingLocation = findStartingPoint(grid);
        uniquePathsHelper(grid, startingLocation[0], startingLocation[1], M, N, visited);
        return validPaths;
    }
    public void uniquePathsHelper(int [][] grid, int currentRow, int currentCol, int rowBound, int colBound, boolean[][] visited){
        if(validLocation(grid, currentRow, currentCol, rowBound, colBound, visited)){
            if(grid[currentRow][currentCol] == 2){
                System.out.println("i made it here " + emptyCells);
                if(emptyCells == 0)
                    validPaths++;
                return;
            }
            visited[currentRow][currentCol] = true;
            emptyCells--;
            uniquePathsHelper(grid, currentRow-1, currentCol, rowBound, colBound, visited);
            uniquePathsHelper(grid, currentRow+1, currentCol, rowBound, colBound, visited);
            uniquePathsHelper(grid, currentRow, currentCol-1, rowBound, colBound, visited);
            uniquePathsHelper(grid, currentRow, currentCol+1, rowBound, colBound, visited);
            visited[currentRow][currentCol] = false;
            emptyCells++;
        }
    }
}