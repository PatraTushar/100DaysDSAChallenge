package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q13 {

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    static List<List<Integer>> Helper(int[] arr, int index, List<Integer> permutation, List<List<Integer>> result) {


        if (index == arr.length) {

            permutation.clear();

            for(int num: arr){

                permutation.add(num);
            }


            result.add(new ArrayList<>(permutation));
            return result;



        }



        for (int i = index; i < arr.length; i++) {

            swap(arr, index, i);
            Helper(arr, index + 1, permutation, result);
            swap(arr,index,i);
        }


        return result;



    }

    static List<List<Integer>> permutation(int[] arr) {

        // Time Complexity: O(n × n!)
        // Space Complexity: O(n × n!)

        return Helper(arr,0,new ArrayList<>(),new ArrayList<>());


    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        List<List<Integer>> ans=permutation(arr);
        System.out.println(ans);


    }


}
