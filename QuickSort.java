package sortingByKK;

import java.util.Scanner;


public class QuickSort {

    static void displayArr(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] +" ");
        }
    }

    static  void swap(int arr[],int x,int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    static int partition(int arr[],int start,int end) {

        int pivot = arr[start];
        int count = 0;

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                count++;
            }
        }

        int pivotidx = start + count;
        swap(arr,start,pivotidx);

        int i = start, j = end;

        while (i < pivotidx && j > pivotidx) {
            while (arr[i] <= pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if(i<pivotidx && j>pivotidx){
                swap(arr,i,j);
                i++;
                j--;
            }

        }
        return pivotidx;
    }



    static void Quicksort(int arr[],int start,int end){
        if(start>=end) return;
        int pi = partition(arr, start, end);
        Quicksort(arr, start, pi-1);
        Quicksort(arr,pi+1,end);

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);


        System.out.println(" enter size of the array ");
        int n=sc.nextInt();
        int arr[]=new int[n];

        System.out.println(" enter " + n + " elements ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(" before sorting ");
        displayArr(arr,n);

        System.out.println();

        Quicksort(arr,0,n-1);

        System.out.println(" after sorting ");
        displayArr(arr,n);

    }
}
