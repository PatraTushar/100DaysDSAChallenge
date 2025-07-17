package StackByStriver.interviewQuestions;

import java.util.Stack;

public class Q13 {

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

    public static void main(String[] args) {

        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleHistogram(arr));


    }
}
