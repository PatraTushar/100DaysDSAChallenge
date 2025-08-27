package TwoPointer_SlidingWindow;


public class Q1 {

    static int windowSum(int[] arr, int start, int k) {

        int sum = 0;

        for (int i = start; i < k + start; i++) {
            sum += arr[i];
        }

        return sum;


    }


    // BRUTEFORCE APPROACH
    static int maxSumInWindow(int[] arr, int k) {

        // Time Complexity: O(n * k)
        //  Space Complexity: O(1)

        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {

            int sum = windowSum(arr, i, k);

            max = Math.max(max, sum);


        }

        return max;


    }

    // OPTIMAL APPROACH
    static int maximumInWindowI(int[] arr, int k) {

        // Time Complexity: O(n)
        //  Space Complexity: O(1)

        int windowSum = 0;
        int n = arr.length;

        for (int i = 0; i < k; i++) {

            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;


    }

    public static void main(String[] args) {

        int[] arr = {-1, 2, 3, 3, 4, 5, -1};
        int k = 4;

        System.out.println(maxSumInWindow(arr, k));

        System.out.println(maximumInWindowI(arr, k));
    }
}
