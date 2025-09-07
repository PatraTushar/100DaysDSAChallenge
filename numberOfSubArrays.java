package TwoPointer_SlidingWindow;

public class Q12 {


    static int subArraysWithSumLessThanEqualToK(int[] arr, int k) {

        if (k < 0) return 0;

        int n = arr.length;
        int totalNiceSubArray = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {

            sum += arr[right]%2;


            while (sum > k) {

                sum -= arr[left]%2;
                left++;
            }

            totalNiceSubArray += (right - left + 1);


        }

        return totalNiceSubArray;
    }

    static int numberOfSubArrays(int[] arr, int k) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)

        return subArraysWithSumLessThanEqualToK(arr, k) - subArraysWithSumLessThanEqualToK(arr, k - 1);
    }


    public static void main(String[] args) {

        // leeTCode->1248

        int[] arr={1,1,2,1,1};
        int k=3;
        System.out.println(numberOfSubArrays(arr,k));

    }
}
