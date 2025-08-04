package sortingByKK;

import java.util.Arrays;

public class BubbleSort {

    static void swap(int arr[],int a,int b){

        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

    static void bubbleSort(int arr[]){

        boolean swapped;

        for(int i=0;i<arr.length-1;i++){

            swapped=false;

            for(int j=1;j<arr.length-i;j++){

                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                    swapped=true;
                }
            }

            // if you did not swap for a particular value of i,it means the array is sorted hence stop the program

            if(swapped==false){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int arr[]={5,3,8,6,2};
        bubbleSort(arr);
    }
}
