package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q12 {

    // ITERATIVE APPROACH
    static List<List<Integer>> subsetWithNoDuplicates(int[] nums) {

        // Time Complexity: O(2ⁿ × n)
        // Space Complexity: O(2ⁿ × n)
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;

            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }


            end = outer.size() - 1;
            int n = outer.size();

            for (int j = start; j < n; j++) {


                List<Integer> inner = new ArrayList<>(outer.get(j));

                inner.add(nums[i]);
                outer.add(inner);
            }


        }

        return outer;


    }

    // RECURSIVE APPROACH

    static List<List<Integer>> subsetsWithoutDuplicatesI(int[] arr) {

        // Time Complexity: O(n log n + 2^n)
        // Space Complexity: O(2ⁿ × n)   2^n → number of subset    //n → max length of each subset (for copy)

        Arrays.sort(arr);

        return Helper(arr, 0, new ArrayList<>(), new ArrayList<>());


    }

    static List<List<Integer>> Helper(int[] arr, int index, List<Integer> subsets, List<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList<>(subsets));
            return result;
        }


        subsets.add(arr[index]);
        Helper(arr, index + 1, subsets, result);



        int nextIndex=index+1;

        while (nextIndex<arr.length && arr[index]==arr[nextIndex]){
            nextIndex++;
        }


        subsets.remove(subsets.size()-1);
        Helper(arr,nextIndex,subsets,result);




        return result;


    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = subsetWithNoDuplicates(arr);
        System.out.println(ans);

        List<List<Integer>> ans1 = subsetsWithoutDuplicatesI(arr);
        System.out.println(ans1);


    }
}
