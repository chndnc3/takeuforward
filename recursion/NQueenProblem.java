package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NQueenProblem {
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        findQueenSolution(ans, board);
        System.out.println(ans);
    }

    private static void findQueenSolution(List<List<String>> ans, char[][] board) {
        int n = board.length;
        int[] rowDs = new int[n];
        int[] upperDs = new int[2*n-1];
        int[] lowerDs = new int[2*n-1];

        solve(0, ans, board, rowDs, upperDs, lowerDs);
    }

    private static void solve(int col, List<List<String>> ans, char[][] board, int[] rowDs, int[] upperDs, int[] lowerDs) {
        int n = board.length;
        List<String> queen = new ArrayList<>();
        if(col==n){
            construct(0, ans, board, queen, n);
            return;
        }
        for(int row=0; row<n; row++){
            if(rowDs[row]==0 && upperDs[n-1+col-row]==0 && lowerDs[col+row]==0){
                board[row][col]='Q';
                rowDs[row]=1;
                upperDs[n-1+col-row]=1;
                lowerDs[col+row]=1;
                solve(col+1, ans, board, rowDs, upperDs, lowerDs);
                board[row][col]='.';
                rowDs[row]=0;
                upperDs[n-1+col-row]=0;
                lowerDs[col+row]=0;
            }
        }
    }

    private static void construct(int row, List<List<String>> ans, char[][] board, List<String> queen, int n) {
        if(row==n){
            ans.add(new ArrayList<>(queen));
            queen.clear();
            return;
        }
        List<Character> rowWise = new ArrayList<>();
        for(int col=0; col<board.length; col++){
            rowWise.add(board[row][col]);
        }
        String queenString = rowWise.stream().map(String::valueOf).collect(Collectors.joining());
        queen.add(queenString);
        construct(row+1, ans, board, queen, n);

    }
}
