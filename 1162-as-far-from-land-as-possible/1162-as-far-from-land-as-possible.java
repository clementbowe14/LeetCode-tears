class Solution {
    
    public int[][] cache;
    public int[][] coord = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxDistance(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList<>();
        cache = new int[grid.length][grid[0].length];
        int ans = 0;
        
        for(int[] arr : cache) {
            Arrays.fill(arr, Integer.MAX_VALUE/2);
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j, 0});
                    cache[i][j] = 0;
                }
            }
        }
        
        while(!queue.isEmpty()){
            
            int [] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            
            for(int i = 0; i < coord.length; i++) {
                int newRow = coord[i][0] + row;
                int newCol = coord[i][1] + col;
                int newSteps = 1 + steps;
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && newSteps < cache[newRow][newCol]) {
                    cache[newRow][newCol] = newSteps;
                    queue.add(new int[] {newRow, newCol, newSteps});
                } 
            }
        }
        
        for(int i = 0; i < cache.length; i++){
            for(int j = 0; j < cache[0].length; j++){
                ans = Math.max(ans, cache[i][j]);
            }
        }
        
        return ans == Integer.MAX_VALUE/2 || ans == 0 ? -1 : ans;
    }
}