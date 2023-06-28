package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeUsingMethod2 {
    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        List<String> result = new ArrayList<>();
        if(maze[0][0]==1){
            findPaths(maze, n, result);
        }
        System.out.println(result);
    }

    private static void findPaths(int[][] maze, int n, List<String> result) {
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j]=0;
            }
        }
        int[] nextI = {1, 0, 0, -1};
        int[] nextJ = {0, -1, 1, 0};
        String s = "DLRU";
        solve(0, 0, maze, n, "", s, nextI, nextJ, result, visited);
    }

    private static void solve(int i, int j, int[][] maze, int n, String s, String dlru, int[] nextI, int[] nextJ, List<String> result, int[][] visited) {
        if(i==n-1 && j==n-1){
            result.add(s);
            return;
        }
        for(int index=0; index<4; index++){
            int nexti = i + nextI[index];
            int nextj = j + nextJ[index];
            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && visited[nexti][nextj]==0 && maze[nexti][nextj]==1) {
                visited[i][j]=1;
                solve(nexti, nextj, maze, n, s+dlru.charAt(index), dlru, nextI, nextJ, result, visited);
                visited[i][j]=0;
            }
        }
    }
}
