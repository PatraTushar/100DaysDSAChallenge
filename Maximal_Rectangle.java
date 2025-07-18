package StackByStriver.interviewQuestions;

import java.util.Stack;

public class Q14 {

    static int largestRectangleHistogram(int[] heights){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(n)

        if (heights == null || heights.length == 0) return 0;


        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int[] pse=new int[n];
        int[] nse=new int[n];


        for(int i=0;i<n;i++){

            while (!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);


        }

        st.clear();


        for(int i=n-1;i>=0;i--){

            while (!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i);


        }

        int largestArea=Integer.MIN_VALUE;
        int sum;

        for (int i=0;i<n;i++){

            sum=heights[i]*(nse[i]-pse[i]-1);
            largestArea=Math.max(largestArea,sum);



        }

        return largestArea;


    }


    static int[][] prefixSum(char[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;
        int[][] prefixSum = new int[rows][cols];


        for(int j=0;j<cols;j++){

            int sum=0;

            for (int i=0;i<rows;i++){

                if (arr[i][j] == '1') sum++;
                else sum = 0;
                prefixSum[i][j] = sum;




            }
        }

        return prefixSum;
    }

    static int maximalRectangle(char[][] matrix) {

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(n)

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;


        int maxArea=0;
        int rows=matrix.length;
        int[][] pSum=prefixSum(matrix);

        for(int i=0;i<rows;i++){

            maxArea=Math.max(maxArea,largestRectangleHistogram(pSum[i]));

        }

        return maxArea;


    }

    public static void main(String[] args) {

      char[][]  matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));


    }
}
