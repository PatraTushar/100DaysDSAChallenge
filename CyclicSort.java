package sortingByKK;

import java.util.Arrays;

public class CyclicSort {

    // Range 1 to n

    static void swap(int arr[],int a,int b){

        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    static void cyclicSort(int arr[]){

        int i=0;

        while(i<arr.length){

            int correct=arr[i]-1;

            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }

            else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void CS(int arr[]){

        // Range o to n

        int i=0;

        while(i<arr.length){
            int correct=arr[i];

            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }

            else{
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arr={5,4,1,3,2};
        cyclicSort(arr);
        int[] arr2={4,3,0,2,1};
        CS(arr2);


    }
}
