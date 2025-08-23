package RecursionByStriver.BackTracking;

public class Q2 {

    public static boolean isSafe(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            if (board[i][col] == ch) {
                return false;
            }

            if (board[row][i] == ch) {
                return false;
            }


            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
                return false;
            }
        }

        return true;
    }

    public static boolean solve(char[][] board) {

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isSafe(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solve(board)) return true;

                            else board[row][col] = '.';

                        }


                    }

                    return false;
                }
            }


        }

        return true;


    }

    public static void solveSudoku(char[][] board) {

        // 🕒 Time Complexity (Worst-case): O(9^n) where n is the number of empty cells
        //Space Complexity: O(1) (excluding recursion stack),

        solve(board);


    }

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '6', '7', '8', '9', '.', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'.', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '.', '4', '8', '5', '6'},
                {'9', '6', '.', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };


        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }
}
