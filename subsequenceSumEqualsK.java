package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q7 {

    static void subsequenceSumEqualsK(int[] arr, int index, List<Integer> subsequence, int currSum, int k) {

        // Time Complexity: O(2ⁿ)
        // Space Complexity: O(n)

        if (index == arr.length) {

            if (currSum == k) {
                System.out.println(subsequence);

            }

            return;
        }


        subsequence.add(arr[index]);
        subsequenceSumEqualsK(arr, index + 1, subsequence, currSum + arr[index], k);

        subsequence.remove(subsequence.size() - 1);
        subsequenceSumEqualsK(arr, index + 1, subsequence, currSum, k);


    }

    static boolean printAnyOneSubsequence(int[] arr, int index, List<Integer> subsequence, int currSum, int k){

        // Time Complexity: O(2ⁿ)
        // Space Complexity: O(n)

        if (index == arr.length) {

            if (currSum == k) {
                System.out.println(subsequence);
                return true;

            }

            return false;


        }


        subsequence.add(arr[index]);
       if( printAnyOneSubsequence(arr, index + 1, subsequence, currSum + arr[index], k)){
           return true;
       }

        subsequence.remove(subsequence.size() - 1);
       if( printAnyOneSubsequence(arr, index + 1, subsequence, currSum, k)){
           return true;
       }

       return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int k = 2;

      //  subsequenceSumEqualsK(arr, 0, new ArrayList<>(), 0, k);
        printAnyOneSubsequence(arr, 0, new ArrayList<>(), 0, k);

    }
}
