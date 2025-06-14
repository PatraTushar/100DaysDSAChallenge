package ArraysbyKK.binarySearchPattern;

public class Q24 {
    static int findMax(int[] arr){

        int max=Integer.MIN_VALUE;

        for(int a:arr){
            if(a>max){
                max=a;
            }
        }

        return max;
    }

    static int findSum(int[] arr){

        int sum=0;
        for(int a: arr){
            sum+=a;
        }
        return sum;
    }

    static int isPossible(int[] arr,int mid){

        int noOfDays=1;
        int capacity=0;

        for(int i=0;i<arr.length;i++){

            if(capacity+arr[i]<=mid){

                capacity+=arr[i];

            }

            else {
                noOfDays++;
                capacity=arr[i];
            }

        }

        return noOfDays;


    }

    static int leastCapacity(int[] arr,int days){

        if(days>arr.length) return -1;

        int start=findMax(arr);
       int end=findSum(arr);



        while (start<=end){

            int mid=start+(end-start)/2;

            int totalDays=isPossible(arr,mid);

            if(totalDays>days){

                start=mid+1;


            }

            else {


                end=mid-1;

            }
        }
        return start;
    }

    public static void main(String[] args) {

        // least capacity to ship packages within d days (leeTCode-->1011)

        int[] arr={1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(leastCapacity(arr,days));

    }
}
