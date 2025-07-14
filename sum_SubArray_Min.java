package StackByStriver.interviewQuestions;

import java.util.Stack;

public class Q7 {

    static int sumSubArrayMin(int[] arr){

        // brute force bt for longer values it gives TLE(Time Limit Exceeded)

        // Time Complexity: O(n²)
        // Space Complexity: O(1)

        int sum=0;
        int MOD = (int) 1e9 + 7;

        for(int i=0;i<arr.length;i++){

            int mini=arr[i];

            for (int j=i;j<arr.length;j++){

                mini=Math.min(mini,arr[j]);
                sum=(sum+mini)% MOD;
            }


        }

        return sum;






    }

    static int sumSubArrayMinII(int[] arr){

        // Optimal Approach

        // Time Complexity (TC): O(N)
        // Space Complexity (SC): O(N)

        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[n];
        int[] nse=new int[n];


        for(int i=0;i<n;i++){

            while (!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=n-1;i>=0;i--){

            while (!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }


        long total=0;
        int MOD = (int) 1e9 + 7;

        for(int i=0;i<n;i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + arr[i] * left * right) % MOD;

        }

        return (int) total;


    }



    public static void main(String[] args) {

        int[] arr={3,1,2,4};
        System.out.println(sumSubArrayMin(arr));
        System.out.println(sumSubArrayMinII(arr));





    }


}
