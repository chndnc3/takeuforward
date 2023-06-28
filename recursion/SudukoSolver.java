package takeUforward.recursion;

public class SudukoSolver {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        if(solveSuduko(board, 9)){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(" "+board[i][j]);
                }
                System.out.println();
            }
        } else{
            System.out.println(false);
        }
    }

    private static boolean solveSuduko(char[][] board, int n) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(canBeFilled(board, i, j, n, ch)){
                            board[i][j]=ch;
                            if(solveSuduko(board, n)){
                                return true;
                            } else{
                                board[i][j]='.';
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean canBeFilled(char[][] board, int row, int col, int n, char ch) {
        for(int i=0; i<n; i++){
            if(board[row][i]==ch){
                return false;
            }
            if(board[i][col]==ch){
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch){
                return false;
            }
        }
        return true;
    }
}
