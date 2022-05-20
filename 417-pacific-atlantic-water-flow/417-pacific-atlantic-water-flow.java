class Solution {
    
    public int [][] coords = new int[][]{{0,1},{1, 0},{0,-1},{-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        
        //pacific to atlantic ignore all non-right && non bottom rows
        for(int i = 0; i < heights.length; i++) {
            dfs(i, 0, heights, pacific, pacificVisited, heights.length-1, heights[0].length-1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < heights[0].length; i++) {
            dfs(0, i, heights, pacific, pacificVisited, heights.length-1, heights[0].length-1, Integer.MIN_VALUE);
        }
        
        for(int i = heights.length-1; i >= 0; i--) {
            dfs(i, heights[0].length-1, heights, atlantic, atlanticVisited, 0, 0, Integer.MIN_VALUE);
        }
        
        for(int i = heights[0].length-1; i >= 0; i--) {
            dfs(heights.length-1, i, heights, atlantic, atlanticVisited, 0, 0, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++){
                if(atlantic[i][j] && pacific[i][j]) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        
        
        return ans;
    }
    
    public void dfs(int row, int col, int[][] heights, boolean[][] ocean, boolean[][] visited, int targetRow, int targetCol, int previousValue){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] < previousValue) {
            return;
        }
        
        if(visited[row][col]) {
            return;
        }
        
        visited[row][col] = true;
        ocean[row][col] = true;
        
        
        for(int i = 0; i < coords.length; i++){
            int newRow = coords[i][0] + row;
            int newCol = coords[i][1] + col;
            dfs(newRow, newCol, heights, ocean, visited, targetRow, targetCol, heights[row][col]);
        }
        
    }
}