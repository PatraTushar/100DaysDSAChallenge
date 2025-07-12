package StackByStriver.interviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class Q3 {

    static int[] nextGreaterElement(int[] arr){

        //  Time Complexity (TC): O(N)
        // Space Complexity (SC): O(N)

        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] nge=new int[arr.length];


        for(int i=n-1;i>=0;i--){

            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

          nge[i]=st.isEmpty() ? -1 : st.peek();

            st.push(arr[i]);
        }

        return nge;


    }

    public static void main(String[] args) {

        int[] arr={4,12,5,3,1,2,5,3,1,2,4,6};
        int[] Ans=nextGreaterElement(arr);
        System.out.println(Arrays.toString(Ans));


    }
}
