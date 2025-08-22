package RecursionByStriver.BackTracking;

import java.util.*;

public class Q1 {


    // APPROACH 1
    static boolean isSafe(int row, int col, List<String> board, int n) {

        int dupRow = row, dupCol = col;

        // Check upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        // Check upper column (same column but previous rows)
        row = dupRow;
        col = dupCol;
        while (row >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
        }

        // Check upper-right diagonal
        row = dupRow;
        col = dupCol;
        while (row >= 0 && col < n) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col++;
        }

        return true;


    }


    static void solve(int row, List<String> board, List<List<String>> result, int n) {


        if (row >= n) {

            result.add(new ArrayList<>(board));
            return;


        }

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, board, n)) {

                // place queen


                char[] rowChars = board.get(row).toCharArray();
                rowChars[col] = 'Q';
                board.set(row, new String(rowChars));

                solve(row + 1, board, result, n);

                // Backtrack
                rowChars[col] = '.';
                board.set(row, new String(rowChars));


            }
        }
    }

    static List<List<String>> solveNQueens(int n) {

        // Time Complexity (TC):  O(N × N!)                         // N options in row 0
        // Space Complexity (SC): O(N²)                                 //× (N-1) options in row 1
                                                                     //× (N-2) options in row 2
                                                                        //...
                                                                       //× 1 option in row N-1


        List<String> board = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        String rowstring = ".".repeat(n);

        for (int i = 0; i < n; i++) {

            board.add(rowstring);
        }


        solve(0, board, result, n);

        return result;
    }


    // APPROACH 2 (OPTIMAL)


    static void solve2(int row, List<String> board, List<List<String>> result, int n, Set<Integer> verticallyUpward, Set<Integer> rightDiagonal, Set<Integer> leftDiagonal) {


        if (row >= n) {

            result.add(new ArrayList<>(board));
            return;


        }

        for (int col = 0; col < n; col++) {

              int rightDiagonalConstant=row+col;
              int leftDiagonalConstant=row-col;

              if(verticallyUpward.contains(col) || rightDiagonal.contains(rightDiagonalConstant) || leftDiagonal.contains(leftDiagonalConstant))
              {
                  continue;
              }

            // Place the queen
            char[] rowChars = board.get(row).toCharArray();
            rowChars[col] = 'Q';
            board.set(row, new String(rowChars));

            // Mark the current verticallyUpward and diagonals as occupied
            verticallyUpward.add(col);
            rightDiagonal.add(rightDiagonalConstant);
            leftDiagonal.add(leftDiagonalConstant);


            solve2(row + 1, board, result, n,verticallyUpward,rightDiagonal,leftDiagonal);

            // Backtrack
            rowChars[col] = '.';
            board.set(row, new String(rowChars));
            verticallyUpward.remove(col);
            rightDiagonal.remove(rightDiagonalConstant);
            leftDiagonal.remove(leftDiagonalConstant);


        }
    }

    static List<List<String>> solveNQueens2(int n) {

        // Time Complexity (TC): O(N!)
        // Space Complexity (SC): O(N²)

        List<String> board = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Set<Integer> verticallyUpward = new HashSet<>();
        Set<Integer> rightDiagonal = new HashSet<>();
        Set<Integer> leftDiagonal = new HashSet<>();
        String rowstring = ".".repeat(n);

        for (int i = 0; i < n; i++) {

            board.add(rowstring);
        }


        solve2(0, board, result, n, verticallyUpward, rightDiagonal, leftDiagonal);

        return result;
    }


    public static void main(String[] args) {


        int n = 4;
        List<List<String>> res = solveNQueens(n);

        for (List<String> solution : res) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }



        System.out.println("-------------------------------------");


        List<List<String>> res1 = solveNQueens2(n);

        for (List<String> solution : res1) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }


    }
}
