package ArraysbyKK.strivers;

import java.util.Arrays;

public class Q25 {

    static int[] findMissingAndRepeatingNumber(int[] arr,int n){         // better solution

       // Time Complexity: O(n)
      //  Space Complexity: O(n)

        int[] freq=new int[n+1];
        int[] result=new int[2];

        for(int i=0;i<arr.length;i++){

            freq[arr[i]]++;
        }


        for(int i=1;i<=n;i++){
            if(freq[i]>1 ){      // repeating
                result[0]=i;

            }

            else if(freq[i]==0){  // missing
                result[1]=i;
            }

        }

        return result;

    }

    static int[] findMissingAndRepeating(int[] arr,long n){  // optimal solution

        //Time Complexity: O(n)
        //Space Complexity: O(1)

        long s1N=(n*(n+1))/2;         // sum of n natural number
        long s2N=(n*(n+1)*(2*n+1))/6;  // sum of square of natural number
        long s1=0;
        long s2=0;

        for(int i=0;i<arr.length;i++){
            s1+=arr[i];
            s2+=(long) arr[i]*(long) arr[i];
        }

        long val1=s1-s1N; // x-y   //-4
        long val2=s2-s2N;         //-24
        val2=val2/val1;  //x+y     // -24/-4=6

        long x=(val1+val2)/2;
        long y=x-val1;

        return new int[]{(int) x,(int) y};




    }

    public static void main(String[] args) {

        int[] arr={4,3,6,2,1,1};
        int n=6;
        int[] ans=findMissingAndRepeatingNumber(arr,n);
        System.out.println(Arrays.toString(ans));

        int[] result=findMissingAndRepeating(arr,n);
        System.out.println(Arrays.toString(result));

    }
}
