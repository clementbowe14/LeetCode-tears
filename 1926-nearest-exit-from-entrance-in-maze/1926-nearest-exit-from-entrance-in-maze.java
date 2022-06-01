class Solution {
    
    int [][] coords = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            
            if(row == 0 || col == 0 || row == maze.length-1 || col == maze[0].length-1){
                if(steps > 0)
                    return steps;
            }
            
            for(int i = 0; i < coords.length; i++){
                int nextRow = row + coords[i][0];
                int nextCol = col + coords[i][1];
                if(nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length && maze[nextRow][nextCol] != '+' && !visited[nextRow][nextCol]){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, steps+1});
                }
            }
        }
        
        return -1;
    }
}