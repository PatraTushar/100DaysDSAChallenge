package sortingByKK;

import java.util.Arrays;

public class MergeSort {

    static void merge(int[] arr,int start,int mid,int end){

       // Time Complexity: O(n log n)
      //  Space Complexity: O(n)

        int[] newArr=new int[end-start+1];

        int i=start;
        int j=mid+1;
        int k=0;

        while (i<=mid && j<=end ) {

            if (arr[i] <= arr[j]) {
                newArr[k] = arr[i];
                i++;

            } else {
                newArr[k] = arr[j];
                j++;

            }

            k++;
        }


        while (i<=mid){
            newArr[k]=arr[i];
            i++;
            k++;
        }
        while (j<=end){
            newArr[k]=arr[j];
            j++;
            k++;
        }

        for(int a=0;a<newArr.length;a++){
            arr[start+a]=newArr[a];
        }



    }


    static void mergeSort(int[] arr,int start,int end){

        if(start>=end) return;


        int mid=start+(end-start)/2;

        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);


    }


    public static void main(String[] args) {
        int[] arr={11,1,10,9,6,8,4,2,5,3,7};
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));





    }
}
