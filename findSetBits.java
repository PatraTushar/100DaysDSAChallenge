package BitManipulation.InterviewQuestions;

public class Q28 {

    static int findSetBits(int num) {

        int setBits = 0;
        for (int i = 0; i < 32; i++) {

            int bit = (num >> i) & 1;
            if (bit != 0) setBits++;
        }

        return setBits;


    }


    static int minimizeXor(int num1, int num2) {

        // Time Complexity : O(32) =O(1)
        // Space Complexity : O(1)

        int x = num1;
        int targetSetBit = findSetBits(num2);
        int currSetBit = findSetBits(x);

        while (currSetBit != targetSetBit) {


            if (currSetBit < targetSetBit) {

                for (int i = 0; i < 32; i++) {

                    int bit = (x >> i) & 1;
                    if (bit == 0) {

                        x = x |  (1 << i);
                        currSetBit++;
                        break;
                    }
                }
            } else {

                for (int i = 0; i < 32; i++) {

                    int bit = (x >> i) & 1;
                    if (bit == 1) {

                        x = x ^ (1 << i);
                        currSetBit--;
                        break;
                    }

                }


            }

        }


        return x;


    }

    public static void main(String[] args) {

        // leeTCode->2429

        int num1 = 1;
        int num2 = 12;
        System.out.println(minimizeXor(num1, num2));


    }
}
