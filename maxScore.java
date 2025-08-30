package TwoPointer_SlidingWindow;

public class Q4 {

    static int maxScore(int[] cardPoints,int k){

        // Time Complexity: O(2k)
        // Space Complexity: O(1)

        int leftSum=0;
        int rightSum=0;
        int maxSum=0;
        int n=cardPoints.length;

        for(int i=0;i<k;i++){

            leftSum+=cardPoints[i];
        }

        maxSum=leftSum;
        int rightIndex=n-1;

        for(int i=k-1;i>=0;i--){

            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rightIndex];
            rightIndex--;
            maxSum=Math.max(maxSum,leftSum+rightSum);


        }

        return maxSum;
    }

    public static void main(String[] args) {

        // leeTCode->1423

        int[] arr={6,2,3,4,7,2,1,7,1};
        int k=4;
        System.out.println(maxScore(arr,k));
    }
}
