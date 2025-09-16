package BitManipulation.InterviewQuestions;

public class Q20 {

    static int numSteps(String s) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)


        int length = s.length();
        int operations = 0;
        int carry = 0;

        for (int i = length - 1; i >= 1; i--) {

            if ((s.charAt(i) - '0' + carry) % 2 == 1) {    // odd

                operations += 2;
                carry = 1;

            } else operations += 1;


        }

        return operations + carry;
    }

    public static void main(String[] args) {

        // leeTCode->1404

        String str = "1101";
        System.out.println(numSteps(str));
    }
}
