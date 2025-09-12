package BitManipulation.InterviewQuestions;

public class Q17 {

    static int minOperation(int[] arr, int k) {

        //  Time Complexity: O(n + 32 ) = O(n)
        //  Space Complexity: O(1)


        int n = arr.length;

        int result = arr[0];

        for (int i = 1; i < n; i++) {

            result = result ^ arr[i];


        }

        result = result ^ k;
        int operations = 0;

        for (int i = 0; i < 32; i++) {

            int bit = (result >> i) & 1;

            if (bit == 1) operations++;
        }

        return operations;
    }

    public static void main(String[] args) {

        // leeTCode->2997

        int[] arr = {2, 1, 3, 4};
        int k = 1;
        System.out.println(minOperation(arr,k));
    }
}
