package ArraysbyKK.strivers;

import java.util.Arrays;

public class Q10 {

    static void swap(int[] arr,int a,int b){

        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    static int[] sort(int[] arr){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)

        int low=0;
        int mid=0;
        int high=arr.length-1;

      while (mid<=high){

            if(arr[mid]==0){

                swap(arr,mid,low);
                low++;
                mid++;



            }

            else if(arr[mid]==1){

                mid++;


            }

            else {

                swap(arr,mid,high);
                high--;


            }
        }


        return arr;


    }

    public static void main(String[] args) {

        // sort the array od 0s 1s and 2s
        int[] arr={0,1,2,0,1,2,1,2,0,0,0,1};
        int[] ans=sort(arr);
        System.out.println(Arrays.toString(ans));



    }
}
