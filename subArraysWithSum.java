package TwoPointer_SlidingWindow;

public class Q11 {


    static int subArraysWithSumLessThanEqualToGoal(int[] arr, int goal) {

        if (goal < 0) return 0;

        int n = arr.length;
        int count = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {

            sum += arr[right];


            while (sum > goal) {

                sum -= arr[left];
                left++;
            }

            count += (right - left + 1);


        }

        return count;
    }

    static int subArraysWithSum(int[] arr, int goal) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)

        return subArraysWithSumLessThanEqualToGoal(arr, goal) - subArraysWithSumLessThanEqualToGoal(arr, goal - 1);
    }


    public static void main(String[] args) {

        // leeTCode->930

        int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(subArraysWithSum(arr, goal));


    }
}
