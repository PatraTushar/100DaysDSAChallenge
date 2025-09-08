package TwoPointer_SlidingWindow;

import java.util.HashMap;

public class Q13 {


    // BRUTEFORCE APPROACH
    static int subArrayWithKDistinct(int[] arr,int k){

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(k)


        int n=arr.length;
        int count=0;


        for(int i=0;i<n;i++){

            HashMap<Integer,Integer> map=new HashMap<>();

            for(int j=i;j<n;j++){

                map.put(arr[j],map.getOrDefault(arr[j],0)+1);

                if(map.size()==k){
                    count++;
                }
            }
        }

        return count;


    }

    static int possibleSubArraysLessThanEqualToK(int[] arr,int k){

        if(k<0) return 0;

        int n=arr.length;
        int count=0;
        int left=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int right=0;right<n;right++){

            map.put(arr[right],map.getOrDefault(arr[right],0)+1);

            while (map.size()>k){

                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0) map.remove(arr[left]);
                left++;
            }




                count+=right-left+1;



        }

        return count;



    }


    static int subArrayWithKDistinctI(int[] arr,int k){


        //  Time Complexity: O(n)
        //  Space Complexity: O(k)

        return possibleSubArraysLessThanEqualToK(arr,k)-possibleSubArraysLessThanEqualToK(arr,k-1);



    }


    public static void main(String[] args) {

        // leeTCode->992

        int[] arr={1,2,1,3,4};
        int k=3;
        System.out.println(subArrayWithKDistinct(arr,k));
        System.out.println(subArrayWithKDistinctI(arr,k));

    }
}
