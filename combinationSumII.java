package RecursionByStriver.InterviewQuestions;

import java.util.*;

public class Q9 {

    // 1ST APPROACH

   // OPTIMAL APPROACH
    static void helper(int[] arr,int index,List<Integer> combination,int target,List<List<Integer>> result){

        if(target==0){

            List<Integer> ans=new ArrayList<>(combination);
            result.add(ans);
            return;
        }

        if(target<0 || index==arr.length){
            return;
        }

        // Take
        combination.add(arr[index]);
        helper(arr,index+1,combination,target-arr[index],result);
        combination.remove(combination.size()-1);

        //  Not Take — ❗ SKIP DUPLICATES HERE
        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) next++;
        helper(arr,next,combination,target,result);
    }

    static List<List<Integer>> combinationSumII(int[] candidates,int target){

        //  Time Complexity: O(2ⁿ * k) (better in practice due to pruning and skipping duplicates)
        // Space Complexity: O(k × x) + O(n)     (O(n) because  we can traverse and build combinations using up to n elements.)

        Arrays.sort(candidates);

        List<List<Integer>> unique=new ArrayList<>();

        helper(candidates,0,new ArrayList<>(),target,unique);

        return new ArrayList<>(unique) ;

    }

    // 2nd APPROACH

   // BRUTEFORCE APPROACH
    static void Helper(int[] arr,int index,List<Integer> combination,int target,Set<List<Integer>> result){

        if(target==0){

            List<Integer> ans=new ArrayList<>(combination);
            result.add(ans);
            return;
        }

        if(target<0 || index==arr.length){
            return;
        }

        // Take
        combination.add(arr[index]);
        Helper(arr,index+1,combination,target-arr[index],result);
        combination.remove(combination.size()-1);
        //  Not Take
        Helper(arr,index+1,combination,target,result);
    }

    static List<List<Integer>> CombinationSumII(int[] candidates,int target){

        //  Time Complexity: O(2ⁿ * k)
        // Space Complexity: O(k × x) + O(n)



        Arrays.sort(candidates);

        Set<List<Integer>> unique=new HashSet<>();

        Helper(candidates,0,new ArrayList<>(),target,unique);

        return new ArrayList<>(unique) ;

    }


    public static void main(String[] args) {

        int[] arr={2,5,2,1,2};
        int target=5;

        List<List<Integer>> list=combinationSumII(arr,target);
        System.out.println(list);

        List<List<Integer>> list2=CombinationSumII(arr,target);
        System.out.println(list2);

    }
}
