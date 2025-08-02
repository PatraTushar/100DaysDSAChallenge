package Hashmap.InterviewQuestion;

import java.util.*;

public class Q4 {

    static int LargestSubArraySum0(int[] arr){

        Map<Integer,Integer> mp=new HashMap<>();
        int prefixSum=0;
        int findMax=0;

        for(int i=0;i<arr.length;i++){

            prefixSum+=arr[i];

            if(prefixSum==0){
                findMax=  Math.max(findMax,i+1);
            }


            if(!mp.containsKey(prefixSum)){
                mp.put(prefixSum,i);

            }

            else {

              if(i-mp.get(prefixSum)>findMax){
                  findMax=i-mp.get(prefixSum);
                }


            }


        }



        return findMax;
    }

    public static void main(String[] args) {

        int[] arr={15,-2,2,-8,1,7,10,23};
        System.out.println(LargestSubArraySum0(arr));


    }
}
