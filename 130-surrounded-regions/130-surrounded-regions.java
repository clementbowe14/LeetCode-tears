class Solution {
    int[][] coords = {{1,0},{-1, 0}, {0, 1}, {0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char region = 'O';
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == region && (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1) && !visited[i][j]){
                    dfs(i, j, visited, board, m, n, region);
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && board[i][j] == region){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    public void dfs(int row, int col, boolean[][] visited, char[][] board, int maxRow, int maxCol, char region){
        if(row >= maxRow || row < 0 || col >= maxCol || col < 0 || board[row][col] != region || visited[row][col] ) {
            return;
        }
        visited[row][col] = true;
        for(int i = 0; i < coords.length; i++){
            int nextRow = row + coords[i][0];
            int nextCol = col + coords[i][1];
            dfs(nextRow, nextCol, visited, board, maxRow, maxCol, region);
        }
    }
}