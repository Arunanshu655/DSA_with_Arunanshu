// Topics: Matrix

class Solution {
    public boolean inTheBox(char[][] board , int row , int col){
         for(int i = ((row / 3) * 3); i <((row / 3) * 3)+3 ; i++){
            for(int j = ((col / 3) * 3); j < ((col / 3) * 3)+3 ; j++){
                if(board[i][j]==board[row][col] && row != i && col != j){
                    return true;
                }
            }
         }
         return false;
    }
    public boolean checkValid(char[][] board, int row , int col){
        int n = board.length;
        if(row >=n ){
            return true;
        }
        if(board[row][col]!='.'){//in row 
        for(int i = col+1 ; i < n ; i++){
            if(board[row][i]==board[row][col]){
                return false;
            }
        }
        //in column
        for(int i = row+1 ; i < n ; i++){
            if(board[i][col]==board[row][col]){
                return false;
            }
        }
        //in box
        if(inTheBox(board,row,col)){
            return false;
        }
        }
        if(col==n-1){
            return checkValid(board,row+1,0);
        }else{
            return checkValid(board,row,col+1);
        }

    }
    public boolean isValidSudoku(char[][] board) {
        return checkValid(board,0,0);
    }
    
}

// Time Complexity: O(n^3)
// Auxiliary Space: O(1)
