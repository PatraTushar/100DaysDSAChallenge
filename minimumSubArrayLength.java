package BitManipulation.InterviewQuestions;

public class Q27 {

    static void updateNum(int n, int[] result) {

        for (int i = 0; i < 32; i++) {

            int bit = (n >> i) & 1;
            if (bit != 0) {

                result[i] = result[i] + 1;

            }
        }
    }

    static void removeNum(int n, int[] result) {

        for (int i = 0; i < 32; i++) {

            int bit = (n >> i) & 1;
            if (bit != 0) {

                result[i] = result[i] - 1;
            }
        }
    }


    static int calcOr(int[] bits) {

        int val = 0;

        for (int i = 0; i < 32; i++) {

            if (bits[i] != 0) {

                val |= (1 << i);
            }
        }

        return val;

    }

    static int minimumSubArrayLength(int[] arr, int k) {

        // Time Complexity : O(n)
        // Space Complexity : O(1)

        // leeTCode->3097

        int n = arr.length;
        int length = Integer.MAX_VALUE;
        int left = 0;
        int[] bitCount = new int[32];

        for (int right = 0; right < n; right++) {

            updateNum(arr[right], bitCount);

            while (left <= right && calcOr(bitCount) >= k) {

                length = Math.min(length, right - left + 1);
                removeNum(arr[left], bitCount);
                left++;

            }


        }

        return length == Integer.MAX_VALUE ? -1 : length;


    }

    public static void main(String[] args) {

        int[] arr = {2, 1, 8};
        int k = 10;
        int[] arr1={3,3,3,2,1,5,5};
        int k1=6;
        System.out.println(minimumSubArrayLength(arr, k));
        System.out.println(minimumSubArrayLength(arr1,k1));

    }
}
