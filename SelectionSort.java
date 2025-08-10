package sortingByKK;

import java.util.Arrays;

public class SelectionSort {

    static void swap(int arr[],int a,int b){

        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

    static int max(int arr[],int start,int end){

        int max=start;

        for(int i=start;i<=end;i++){

            if(arr[i]>arr[max]){
                max=i;
            }

        }

        return max;
    }

    static void selection(int arr[]){

        for(int i=0;i<arr.length-1;i++){

            // find the maximum from the array and put at its correct position
            int Last=arr.length-i-1;
            int findMax=max(arr,0, Last);
            swap(arr,findMax,Last);

        }

        System.out.println(Arrays.toString(arr));


    }

    public static void main(String[] args) {

        int arr[]={29,10,14,37,13};
        selection(arr);
    }
}
