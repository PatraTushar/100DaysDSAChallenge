package RecursionByStriver.BackTracking;

import java.util.ArrayList;

public class Q4 {

    // Directions: D, L, R, U
    static int[] dRow = {1, 0, 0, -1};
    static int[] dCol = {0, -1, 1, 0};
    static char[] dir = {'D', 'L', 'R', 'U'};

    static void solve(int row, int col, int[][] maze, String path, ArrayList<String> result, int n) {

        // Base case: invalid cell or already visited
        if (row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0) return;

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Mark cell as visited
        maze[row][col] = 0;

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            solve(nextRow, nextCol, maze, path + dir[i], result, n);
        }

        // Backtrack
        maze[row][col] = 1;
    }

    static ArrayList<String> ratInMaze(int[][] maze) {

        // Time Complexity: O(4^(n^2))
        //Space Complexity: O(n^2) (recursion + result)


        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 1)  solve(0, 0, maze, "", result, n);

        return result;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        ArrayList<String> paths = ratInMaze(maze);
        System.out.println("All possible paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
