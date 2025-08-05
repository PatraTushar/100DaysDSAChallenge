package sortingByKK;

import java.util.Scanner;

public class CountSort {

    static void displayArr(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i] +" ");
        }
    }

    static int findMax(int arr[],int n){

        int mx=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if(arr[i]>mx){

                mx=arr[i];

            }
        }

        return mx;

    }

    static void basiccountsort(int arr[],int n){      //

        int max=findMax(arr,n);

        int freq[]=new int[max+1];

        for(int i=0;i<arr.length;i++){

            freq[arr[i]]++;
        }

        int k=0;
        for(int i=0;i< freq.length;i++){
            for(int j=0;j<freq[i];j++){
                arr[k++]=i;
            }
        }








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

        basiccountsort(arr,n);

        System.out.println("after sorting");
        displayArr(arr,n);
    }
}
