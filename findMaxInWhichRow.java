package ArraysbyKK.strivers;

import java.util.Arrays;

public class  Q29 {

    static int findMAxInWhichRow(int[][] arr, int rows, int cols){

        int max=Integer.MIN_VALUE;
        int row=-1;

        for(int i=0;i<rows;i++){

            if(arr[i][cols]>max){
                max=arr[i][cols];
                row=i;
            }



        }

        return row;


    }

    static int[] peakElementII(int[][] arr){

        //Time Complexity (TC): O(n * log m)
        //Space Complexity (SC): O(1)

        int low=0;
        int high=arr[0].length-1;
        int rows=arr.length;
        int cols=arr[0].length;

        while (low <= high){

            int mid=low+(high-low)/2;

            int rowHasMax= findMAxInWhichRow(arr,rows,mid);

            if((mid==0 || arr[rowHasMax][mid]>arr[rowHasMax][mid-1]) && (mid==cols-1 || arr[rowHasMax][mid] >arr[rowHasMax][mid+1])){

                return new int[]{rowHasMax,mid};

            }

            else if(arr[rowHasMax][mid]>arr[rowHasMax][mid+1]){
                high=mid;
            }

            else {
                low=mid+1;
            }
        }

        return new int[]{-1,-1};
    }



    public static void main(String[] args) {

        // peak element II  (leeTCode->1901)

        int[][] arr={{4,2,5,1,4,5},{2,9,3,2,3,2},{1,7,6,0,1,3},{3,6,2,3,7,2}};
        int[] ans=peakElementII(arr);
        System.out.println(Arrays.toString(ans));


    }
}
