package BitManipulation.InterviewQuestions;

public class Q16 {


    // BRUTE FORCE APPROACH
    static int rangeBitwise1(int left, int right) {

        //  Time Complexity: O(right-left)
        //  Space Complexity: O(1)


        int result = left;
        for (int i = left + 1; i <= right; i++) {

            result = result & i;

            if(result==0) break;


        }

        return result;


    }


    static int rangeBitwiseEnd(int left, int right) {

        //  Time Complexity: O(32)->O(1)
        //  Space Complexity: O(1)


        int shiftCount = 0;

        while (left != right) {

            left = left >> 1;
            right = right >> 1;
            shiftCount++;
        }

        return left << shiftCount;
    }

    public static void main(String[] args) {

        // leeTCode->201


        int left = 5;
        int right = 7;
        System.out.println(rangeBitwiseEnd(left, right));
        System.out.println(rangeBitwiseEnd(10, 13));
        System.out.println(rangeBitwise1(10, 13));

    }
}
