package BitManipulation.InterviewQuestions;

import java.util.HashMap;

public class Q30 {


    // BRUTE FORCE APPROACH (FOR LARGER INPUTS TLE)

    static int xorAllNum(int[] num1, int[] num2) {

        // Time Complexity : O(m*n)
        // Space Complexity : O(m*n)


        int m = num1.length;
        int n = num2.length;
        int[] result = new int[m * n];
        int k = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                result[k++] = num1[i] ^ num2[j];
            }
        }

        int xor = 0;

        for (int i = 0; i < result.length; i++) {

            xor = xor ^ result[i];


        }

        return xor;

    }


    // BETTER SOLUTION

    static int xorAllNumI(int[] num1, int[] num2) {

        // Time Complexity : O(m+ n)
        // Space Complexity : O(m+n)

        int m = num1.length;
        int n = num2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {

            map.put(num1[i], map.getOrDefault(num1[i], 0) + n);
        }


        for (int i = 0; i < n; i++) {

            map.put(num2[i], map.getOrDefault(num2[i], 0) + m);
        }


        int xor = 0;

        for (int key : map.keySet()) {

            if (map.get(key) % 2 != 0) {

                xor ^= key;
            }


        }

        return xor;


    }


    // OPTIMAL SOLUTION
    static int xorAllNumII(int[] num1, int[] num2) {

        // Time Complexity : O(m+ n)
        // Space Complexity : O(1)

        int m = num1.length;
        int n = num2.length;
        int xorOfNum1 = 0;
        int xorOfNum2 = 0;
        int result = 0;


        for (int ele : num1) {

            xorOfNum1 ^= ele;
        }

        for (int ele : num2) {

            xorOfNum2 ^= ele;
        }

        if (m % 2 != 0) {

            result ^= xorOfNum2;
        }

        if (n % 2 != 0) {

            result ^= xorOfNum1;
        }

        return result;


    }


    public static void main(String[] args) {

        // leeTCode->2425

        int[] num1 = {2, 1, 3};
        int[] num2 = {10, 2, 5, 0};
        System.out.println(xorAllNum(num1, num2));
        System.out.println(xorAllNumI(num1, num2));
        System.out.println(xorAllNumII(num1, num2));
    }
}
