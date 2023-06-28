package takeUforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeUsingMethod1 {
    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};

        List<String> result = new ArrayList<>();
        findPaths(maze, n, result);
        System.out.println(result);
    }

    private static void findPaths(int[][] maze, int n, List<String> result) {
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                visited[i][j]=0;
            }
        }
        if(maze[0][0]==1){
            solve(0, 0, maze, n, visited, "", result);
        }
    }

    private static void solve(int i, int j, int[][] maze, int n, int[][] visited, String s, List<String> result) {
        if(i==n-1 && j==n-1){
            result.add(s);
            return;
        }

        // downward
        if(i+1<n && visited[i+1][j]==0 && maze[i+1][j]==1) {
            visited[i][j]=1;
            solve(i+1, j, maze, n, visited, s+'D', result);
            visited[i][j]=0;
        }

        // leftward
        if(j-1>=0 && visited[i][j-1]==0 && maze[i][j-1]==1) {
            visited[i][j]=1;
            solve(i, j-1, maze, n, visited, s+'L', result);
            visited[i][j]=0;
        }

        // rightward
        if(j+1<n && visited[i][j+1]==0 && maze[i][j+1]==1) {
            visited[i][j]=1;
            solve(i, j+1, maze, n, visited, s+'R', result);
            visited[i][j]=0;
        }

        // upward
        if(i-1>=0 && visited[i-1][j]==0 && maze[i-1][j]==1) {
            visited[i][j]=1;
            solve(i-1, j, maze, n, visited, s+'U', result);
            visited[i][j]=0;
        }
    }
}
