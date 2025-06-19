package ArraysbyKK.strivers;

import java.util.Arrays;

public class Q24 {

    static void mergeI(int[] arr1, int m, int[] arr2, int n) {   // brute force approach

      //  Time Complexity: O(m + n)
      //  Space Complexity: O(m + n)

        int[] result=new int[m+n];

        int i=0;
        int j=0;
        int k=0;

        while(i<m && j<n){
            if(arr1[i]<=arr2[j]){

                result[k]=arr1[i];
                i++;

            }

            else{
                result[k]=arr2[j];
                j++;

            }

            k++;
        }



        while(i<m){
            result[k]=arr1[i];
            i++;
            k++;
        }

        while(j<n){
            result[k]=arr2[j];
            j++;
            k++;
        }

        for (int index = 0; index < m + n; index++) {
            arr1[index] = result[index];
        }

        System.out.println(Arrays.toString(arr1));



    }

    static void mergeII(int[] arr1,int m,int[] arr2,int n){

        // Optimal solution of leeTCode 88

        //Time Complexity: O(m + n)
        //Space Complexity: O(1)

        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while (i>=0 && j>=0){

            if(arr1[i]>arr2[j]){
                arr1[k]=arr1[i];
                i--;
            }

            else {

                arr1[k]=arr2[j];
                j--;
            }
            k--;
        }

        System.out.println(Arrays.toString(arr1));
    }

    static void swapIfGreater(int[] arr1,int[] arr2,int i,int j){

        if(arr1[i]>arr2[j]){
            int temp=arr1[i];
            arr1[i]=arr2[j];
            arr2[j]=temp;
        }
    }

    static void merge(int[] arr1,int[] arr2,int m,int n){

        //TC = O((m + n) * log(m + n))
        //SC = O(1)


        //🧠 Purpose of Your Code
        //You are:
        //Merging two sorted arrays arr1[] of size m and arr2[] of size n
        //Using the Gap Method (Shell Sort concept) to do this in-place (i.e., without using extra space)
        //Ensuring the final result is sorted across both arrays

        int length=m+n;
        int gap=(length/2)+(length%2);


        while (gap>0){

            int left=0;
            int right=gap;

            while (right<length){


                // Case 1: both pointers in arr1
                if (left < m && right < m) {
                    swapIfGreater(arr1, arr1, left, right);
                }

                // Case 2: left in arr1, right in arr2
                else if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                }

                // Case 3: both pointers in arr2
                else {
                    swapIfGreater(arr2, arr2, left - m, right - m);
                }

                left++;
                right++;
            }

            if(gap==1) break;
            gap=(gap/2)+(gap%2);



        }

        System.out.print(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));


    }






    public static void main(String[] args) {

        // merge sorted array (leeTCode->88)
        int[] arr1={1,2,3,0,0,0};
        int m=3;
        int[] arr2={2,5,6};
        int n=3;
        merge(arr1,arr2,m,n);
        mergeII(arr1,m,arr2,n);




    }
}
