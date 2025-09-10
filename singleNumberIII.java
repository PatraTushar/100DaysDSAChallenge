package BitManipulation.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q5 {


    // BRUTE FORCE APPROACH
    static int[] singleNumberIII(int[] arr){

        //  Time Complexity: O(n+k+l)   n → size of the input array     k → number of keys in the map     l → total number of elements across all lists in the map
        //  Space Complexity: O(n+k+l)  n → storing the elements of the array in the map   k → storing the unique elements of the map in a list    l → copying elements from the list back into the map

        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();


        for (int i=0;i<n;i++){

            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int key:map.keySet()){

            if(map.get(key)==1) list.add(key);
        }

        int size=list.size();
        int[] result=new int[size];


        for(int i=0;i<list.size();i++){

            result[i]=list.get(i);
        }




        return result;


    }


    static int[] singleNumber3(int[] arr){

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)

        int n=arr.length;
        int XOR=0;

        for(int i=0;i<n;i++){

            XOR^=arr[i];
        }

        int rightMost=(XOR & (XOR-1))^XOR ;

        int bucket1=0;
        int bucket2=0;

        for (int i=0;i<n;i++){

            if((arr[i] & rightMost) !=0) bucket1=bucket1^arr[i];

            else bucket2=bucket2^arr[i];
        }

        return new int[]{bucket1,bucket2};
    }

    public static void main(String[] args) {

        // leeTCode->260

        int[] arr={1,2,1,3,2,5};
        int[] ans=singleNumberIII(arr);
        System.out.println(Arrays.toString(ans));
        int[] ans1=singleNumber3(arr);
        System.out.println(Arrays.toString(ans1));
    }
}
