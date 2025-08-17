package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q8 {

    static void helper(int[] arr, int index, List<Integer> combination, int target, List<List<Integer>> result) {

        if (target == 0) {
            List<Integer> sorted = new ArrayList<>(combination);
            result.add(sorted);
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        combination.add(arr[index]);
        helper(arr, index, combination, target - arr[index], result);
        combination.remove(combination.size() - 1);
        helper(arr, index + 1, combination, target, result);


    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Time Complexity = O(2^t × k)   2^t: Number of recursive calls (each element can be included or not — exponential choices   k: Time to copy each combination into the result list
        // Space Complexity = O(k × x)  x: Total number of valid combinations stored  k: Length of each stored combination

        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target, result);

        return result;


    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = combinationSum(arr, target);
        System.out.println(ans);
    }
}
