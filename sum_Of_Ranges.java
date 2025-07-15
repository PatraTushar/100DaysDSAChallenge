package StackByStriver.interviewQuestions;

import java.util.Stack;

public class Q10 {

    static long subArrayRanges(int[] arr){

        // BruteForce Approach

        // Time Complexity (TC): O(N²)
        // Space Complexity (SC): O(1)

        long total=0;
        int diff;
        int n=arr.length;


        for(int i=0;i<n;i++){

            int largest=arr[i];
            int smallest=arr[i];


            for(int j=i;j<arr.length;j++){

                largest=Math.max(largest,arr[j]);
                smallest=Math.min(smallest,arr[j]);
                diff=largest-smallest;
                total+=diff;
            }
        }

        return total;
    }

    static long sumOfSubArrMin(int[] arr){

        //Time Complexity (TC): O(N)
        //Space Complexity (SC): O(N)

        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] pse=new int[n];
        int[] nse=new int[n];


        for(int i=0;i<n;i++){

            while (!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            pse[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i=n-1;i>=0;i--){

            while (!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            nse[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }


        long total=0;

        for(int i=0;i<n;i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + arr[i] * left * right) ;

        }


        return  total;






    }

    static long sumOfSubArrMax(int[] arr){

        //Time Complexity (TC): O(N)
        //Space Complexity (SC): O(N)

        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] pge=new int[n];
        int[] nge=new int[n];

        for(int i=0;i<n;i++){

            while (!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            pge[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i=n-1;i>=0;i--){

            while (!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }

            nge[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }




        long total=0;


        for(int i=0;i<n;i++){
            long left = i - pge[i];
            long right = nge[i] - i;
            total = (total + arr[i] * left * right);

        }

        return  total;




    }

    static long sumOfRanges(int[] arr){

        //Time Complexity (TC): O(N)
        //Space Complexity (SC): O(N)

        return sumOfSubArrMax(arr)-sumOfSubArrMin(arr);
    }




    public static void main(String[] args) {
        int[] arr={1,4,3,2};
        System.out.println(sumOfRanges(arr));


    }
}
