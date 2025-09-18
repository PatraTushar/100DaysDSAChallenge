package BitManipulation.InterviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class Q25 {

    // BRUTE FORCE APPROACH (FOR LARGER INPUT TLE)

    static int[] getMaximumXor(int[] arr, int maximumBit) {

        // Time Complexity : O(n² + n·k)
        // Space Complexity : O(n)

        int n = arr.length;
        int[] result = new int[n];
        int k = (int) Math.pow(2, maximumBit);


        for (int i = n - 1; i >= 0; i--) {

            int xor = 0;


            for (int j = i; j >= 0; j--) {

                xor = xor ^ arr[j];


            }


            int maxVal = -1;
            int bestK = 0;

            for (int a = 0; a < k; a++) {

                int candidate = xor ^ a;

                if (candidate > maxVal) {

                    maxVal = candidate;
                    bestK = a;
                }


            }

            result[n - i - 1] = bestK;

        }

        return result;


    }


    static int[] getMaximumXorI(int[] arr, int maximumBit) {

        // Time Complexity : O(n + n )=O(n)
        // Space Complexity : O(n)



        int n=arr.length;
        int[] result=new int[n];
        int limit=(1<<maximumBit)-1;
        int totalXor=0;

        for (int i=0;i<n;i++){

            totalXor^=arr[i];


        }

        for (int i=0;i<n;i++){

            result[i]=totalXor^limit;
            totalXor^=arr[n-i-1];
        }

        return result;


    }

    public static void main(String[] args) {

        // leeTCode->1829

        int[] arr = {0, 1, 1, 3};
        int maximumBit = 2;

        int[] ans = getMaximumXor(arr, maximumBit);
        System.out.println(Arrays.toString(ans));

        int[] ans1=getMaximumXorI(arr,maximumBit);
        System.out.println(Arrays.toString(ans1));
    }
}
