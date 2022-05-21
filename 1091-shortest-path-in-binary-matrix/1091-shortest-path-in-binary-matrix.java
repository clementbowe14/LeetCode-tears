class Solution {
    
    public int[][] coords = {{0,1},{0,-1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0][0] == 1){
            return -1;
        }
        
        int[][] dp = new int[grid.length][grid.length];
        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE/2);
        
        dp[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();     
        queue.add(new int[]{0,0, dp[0][0]});
        
        while(!queue.isEmpty()) {
            int [] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            
            for(int i = 0; i < coords.length; i++) {
                int newRow = row + coords[i][0];
                int newCol = col + coords[i][1];
                int newSteps = 1 + steps;
                
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length &&
                   newSteps < dp[newRow][newCol] && grid[newRow][newCol] == 0){
                    dp[newRow][newCol] = newSteps;
                    queue.add(new int [] {newRow, newCol, newSteps});
                }
            }
        }
        
        return dp[grid.length-1][grid.length-1] == Integer.MAX_VALUE/2 ? -1 : dp[grid.length-1][grid.length-1];
    }
}