package ArraysbyKK.strivers;

public class Q30 {

    static int findMedian(int[][] arr){

        int rows=arr.length;
        int cols=arr[0].length;
        int totalLength=rows * cols;
        int median =totalLength/2;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<rows;i++){

            low=Math.min(low,arr[i][0]);
            high=Math.max(high,arr[i][cols-1]);

        }


        while (low < high){

            int mid=low+(high-low)/2;

            int count=0;

            for(int i=0;i<rows;i++){

                count+=countLessThanOrEqual(arr[i],mid);

            }

            if(count<=median){

                low=mid+1;
            }

            else {

                high=mid;
            }
        }

        return low;


    }

    static int countLessThanOrEqual(int[] arr,int target){

        int low=0;

        int high=arr.length-1;


        while (low <= high){


            int mid=low+(high-low)/2;

            if(arr[mid]<=target){
                low=mid+1;

            }

            else {


                high=mid-1;

            }
        }




        return low;

    }
    public static void main(String[] args) {

        int[][] arr={{1,5,7,9,11},{2,3,4,5,10},{9,10,12,14,16}};
        System.out.println(findMedian(arr));


    }
}
