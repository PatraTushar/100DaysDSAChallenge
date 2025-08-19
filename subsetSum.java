package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q10 {


    // NORMALLY PRINTING THE SUBSETS
    static void subsetSum(int[] arr,int index,int sum){

        //  Time Complexity: O(2ⁿ)
        // Space Complexity: O(n)

        if(index==arr.length){
            System.out.print(sum +" ");
            return;
        }

        subsetSum(arr,index+1,sum);
        subsetSum(arr,index+1,sum+arr[index]);
    }




    // RETURNING THE SUBSETS IN A LIST
    static ArrayList<Integer> Helper(int[] arr, int index, int sum, ArrayList<Integer> list){


        if(index==arr.length){
            list.add(sum);
            return list;
        }

        Helper(arr,index+1,sum+arr[index],list);
        Helper(arr,index+1,sum,list);


        return list;

    }


    static ArrayList<Integer> subsetSumI(int[] arr){


        //  Time Complexity: O(2ⁿ log 2ⁿ)       generate all subset sums (2^n), then sort them using Collections.sort()
        // Space Complexity: 	O(2ⁿ)

        ArrayList<Integer> sumOfSubsets=Helper(arr,0,0,new ArrayList<>());
        Collections.sort(sumOfSubsets);
        return sumOfSubsets;


    }


    public static void main(String[] args) {

        int[] arr={3,1,2};
        subsetSum(arr,0,0);

        System.out.println();

        List<Integer> subsets= subsetSumI(arr);
        System.out.println(subsets);
    }
}
