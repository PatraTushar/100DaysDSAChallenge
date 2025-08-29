package TwoPointer_SlidingWindow;

public class Q3 {


    static int minSubArrayLength(int[] arr, int target) {

        // Time Complexity: O(n)
        // Space Complexity: O(1)


        int n = arr.length;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;


        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum >= target) {

                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left];
                left++;
            }


        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {

        // leeTCode->209

        int[] arr = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLength(arr, target));


    }
}
