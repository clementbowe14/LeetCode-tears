class Solution {
    int[][] coords = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});
        int n = maze.length;
        int m = maze[0].length;
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int steps = node[2];
            if(steps > 0 && (row == 0 || row == n-1 || col == 0 || col == m-1)){
                return steps;
            }
            for(int [] coord : coords){
                int nextRow = coord[0] + row;
                int nextCol = coord[1] + col;
                int nextSteps = 1 + steps;
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol] && maze[nextRow][nextCol] == '.'){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol, nextSteps});
                }
            }
        }
        
        return -1;
        
    }
}