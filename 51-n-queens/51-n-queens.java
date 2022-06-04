class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int [][] board = new int[n][n];
        findNQueens(board, ans, 0);
        return ans; 
    }
    
    //finds the valid queens at each position if it reaches length n then it has found a valid N Queen solution
    public void findNQueens(int [][] board, List<List<String>> ans, int col){
        if(col == board.length){
            
            List<String> curr = createNqueens(board);
            ans.add(new ArrayList<String>(curr));
            return; 
        } else{
            for(int i = 0; i < board.length; i++){
                board[i][col] = 1;
                if(checkHorizontal(board, i, col, false) && checkDiagonals(board, i, col, false)){
                    findNQueens(board, ans, col+1);
                }
                board[i][col] = 0;
            }
        }
        
    }
    
    
    //check the horizontal positions of queens
    public boolean checkHorizontal(int[][] board, int row, int col, boolean queenLoc){
        
        int j = col;
        
        while(j < board.length){
            if(board[row][j] == 1 && queenLoc){
                return false;
            }
            else if(board[row][j] == 1){
                queenLoc = true;
            }
            j++;
        }
        j = col;
        queenLoc = false;
        while(j >= 0){
            if(board[row][j] == 1 && queenLoc){
                return false;
            }
            else if(board[row][j] == 1){
                queenLoc = true;
            }
            j--;          
        }
        
        return true;
    }
    
    //checking the diagonal positions of queens 
    public boolean checkDiagonals(int [][]board, int row, int col, boolean queenLoc){
        int i = row;
        int j = col;
        
        while(i < board.length && j < board.length){
            if(board[i][j] == 1 && queenLoc){
            return false;
            } 
        
            if(board[i][j] == 1){
            queenLoc = true; 
            }
            j++;
            i++;
        }
        
        i = row;
        j = col;
        queenLoc = false; 
        
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1 && queenLoc){
            return false;
            } 
        
            if(board[i][j] == 1){
            queenLoc = true; 
            }
            i--;
            j--;
        }
        
        i = row;
        j = col;
        queenLoc = false; 
        
        while(i >= 0 && j < board.length){
            if(board[i][j] == 1 && queenLoc){
            return false;
            } 
        
            if(board[i][j] == 1){
            queenLoc = true; 
            }
            i--;
            j++;
        }
        
         i = row;
        j = col;
        queenLoc = false; 
        
        while(i < board.length && j >= 0){
            if(board[i][j] == 1 && queenLoc){
            return false;
            } 
        
            if(board[i][j] == 1){
            queenLoc = true; 
            }
            i++;
            j--;
        }
        
        return true; 
    }
    
    //create successful N queens string list
    public List<String> createNqueens(int[][] board){
        List<String> queens = new ArrayList<>(); 
        for(int i = 0; i < board.length; i++){
            String str = "";
            for(int j = 0; j < board.length; j++){
                if(board[j][i] == 1){
                    str += 'Q';
                } else{
                    str += '.';
                }
            }
            queens.add(str);
        }
        return queens;
    }
    
    
}