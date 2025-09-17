package BitManipulation.InterviewQuestions;

public class Q29 {

    static boolean doesValidArrayExist(int[] derived) {

        // Time Complexity : O(n)
        // Space Complexity : O(1)

        int n = derived.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {

            xor ^= derived[i];


        }

        return xor == 0;


    }

    public static void main(String[] args) {

        // leeTCode->2683

        int[] derived = {1, 1, 0};
        System.out.println(doesValidArrayExist(derived));


    }
}
