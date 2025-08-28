package TwoPointer_SlidingWindow;

public class Q2 {

    // BRUTEFORCE APPROACH
    static int longestSubArrayLength(int[] arr, int k) {

        // Time Complexity: O(n^2)  --> Two nested loops in worst case
        // Space Complexity: O(1)   --> Only a few variables used, no extra data structures

        int maxLength = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int sum = arr[i];

            for (int j = i; j < n; j++) {

                sum += arr[j];

                if (sum <= k) {

                    maxLength = Math.max(maxLength, j - i + 1);
                } else {

                    break;
                }
            }
        }

        return maxLength;


    }

    // OPTIMAL SOLUTION

    static int longestSubArrayLengthI(int[] arr,int k){

        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int n=arr.length;
        int left=0;
        int sum=0;
        int maxLength=0;

        for(int right=0;right<n;right++){


            sum+=arr[right];


            while (sum>k){

                sum-=arr[left];
                left++;
            }

            maxLength=Math.max(maxLength,right-left+1);




        }

        return maxLength;


    }







    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 7, 10};
        int k = 14;

        System.out.println(longestSubArrayLength(arr, k));
        System.out.println(longestSubArrayLengthI(arr,k));


    }
}
