package StackByStriver.interviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class Q4 {

    static int[] nextGreaterElementII(int[] arr){

        // Time Complexity (TC): O(N)
        // Space Complexity (SC): O(N)

        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[arr.length];

        for(int i=2*n-1;i>=0;i--){

            while (!st.isEmpty() && st.peek()<=arr[i%n]){
                st.pop();
            }

           if(i<n){
               nge[i]= st.isEmpty() ? -1 : st.peek();
           }
            st.push(arr[i%n]);
        }

        return nge;

    }

    public static void main(String[] args) {

        int[] arr={2,10,12,1,11};
        int[] ans=nextGreaterElementII(arr);
        System.out.println(Arrays.toString(ans));


    }
}
