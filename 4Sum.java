package ArraysbyKK.strivers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q21 {

    static List<List<Integer>> fourSum(int[] arr,int target) {

        //Time Complexity (TC): O(n³)
        //Space Complexity (SC):
        //O(1) (excluding the space used for the output list)
        //O(k) where k is the number of quadruplets in the result.

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        int i = 0;
        int n = arr.length;

        while (i < n - 3) {

            int j = i + 1;


            while (j < n - 2) {
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

                    if (sum < target) {
                        k++;
                    }
                    else if (sum > target) {
                        l--;
                    }
                    else {

                        List<Integer> sum4=Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        result.add(sum4);


                        int eleK=arr[k];
                        int eleL=arr[l];

                        while (k<l && eleK==arr[k]){
                            k++;
                        }

                        while (k<l && eleL==arr[l]){
                            l--;
                        }

                    }
                }


                int eleJ=arr[j];

                while (j<n-2 && eleJ==arr[j]){
                    j++;

                }
            }

            int eleI=arr[i];
            while (i<n-3 && eleI==arr[i]){
                i++;
            }


        }

        return result;





    }

    public static void main(String[] args) {

        // 4 sum (leeTCode->15)

        int[] arr={1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        int target=8;
        List<List<Integer>> ans=fourSum(arr,target);
        System.out.println(ans);

    }
}
