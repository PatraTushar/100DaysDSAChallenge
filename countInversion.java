package RecursionByStriver.BackTracking;

public class Q6 {


    // BRUTEFORCE APPROACH
    public static int countInversion(int[] arr){

        // Time Complexity (TC): O(n^2)
        // Space Complexity (SC): O(1)

        int count =0;

        for(int i=0;i< arr.length-1;i++){

            for(int j=i+1;j<arr.length;j++){

                if(arr[i]>arr[j]) count++;
            }


        }

        return count;
    }


    static void merge(int[] arr,int start,int end,int[] count){

        if(start==end) return;

        int mid=start+(end-start)/2;

        merge(arr,start,mid,count);
        merge(arr,mid+1,end,count);
       mergeSort(arr,start,mid,end,count);

    }

    static void mergeSort(int[] arr,int start,int mid,int end,int[] count){

        int i=start;
        int j=mid+1;
        int k=0;


        int[] mergeArray=new int[end-start+1];

        while (i<=mid && j<=end){

            if(arr[i]<=arr[j]){
                mergeArray[k]=arr[i];
                i++;
            }

            else {
                mergeArray[k]=arr[j];
                j++;
                count[0]+=mid-i+1;
            }

            k++;
        }


        while (i<=mid){

            mergeArray[k]=arr[i];
            i++;
            k++;
        }

        while (j<=end){

            mergeArray[k]=arr[j];
            j++;
            k++;
        }

        for(int a=0;a<mergeArray.length;a++){
            arr[start+a]=mergeArray[a];
        }







    }

    // OPTIMAL SOLUTION
    public static int countInversionI(int[] arr){

        // Time Complexity (TC): O(n log n)
        // Space Complexity (SC): O(n)

        int[] count=new int[1];
        merge(arr,0,arr.length-1,count);

        return count[0];







    }




    public static void main(String[] args) {

        int[] arr={5,3,2,4,1};
        System.out.println(countInversion(arr));
        System.out.println(countInversionI(arr));
    }
}
.java
