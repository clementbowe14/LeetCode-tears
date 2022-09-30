class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> boxes = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.')
                    continue;
                int boardValue = (int)board[i][j];
                String row = String.format("%d row %d", boardValue, i);
                String col = String.format("%d col %d", boardValue, j);
                String box = String.format("%d %d %d", boardValue, i/3, j/3);
                if(!rows.add(row) || !cols.add(col) || !boxes.add(box))
                    return false;
            }
        }
        
        return true;
    }
}