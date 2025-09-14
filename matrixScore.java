package BitManipulation.InterviewQuestions;

public class Q19 {


    static int matrixScore(int[][] grid) {

        //  Time Complexity: O(row*col)
        //  Space Complexity: O(1)


        int row = grid.length;
        int col = grid[0].length;


        // Set first column value in each row
        for (int i = 0; i < row; i++) {

            if (grid[i][0] == 0) {

                // Flip that row


                for (int j = 0; j < col; j++) {

                    if (grid[i][j] == 1) grid[i][j] = 0;
                    else grid[i][j] = 1;


                }


            }

        }



        for(int j=1;j<col;j++){

            int countZeroes=0;
            int countOnes=0;

            for(int i=0;i<row;i++){

                if(grid[i][j]==0) countZeroes++;
                else countOnes++;
            }

            if(countZeroes>countOnes){

                for(int i=0;i<row;i++){

                    if(grid[i][j]==0) grid[i][j]=1;
                    else grid[i][j]=0;
                }
            }
        }


        int score=0;


        for (int i=0;i<row;i++){

            for (int j=0;j<col;j++){

                score+=grid[i][j]*Math.pow(2,col-j-1);
            }
        }

        return score;


    }

    public static void main(String[] args) {

        // leeTCode->861

        int[][] grid = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(grid));

    }
}
