package TwoPointer_SlidingWindow;


import java.util.HashMap;
import java.util.HashSet;

public class Q7 {


    // BRUTE FORCE APPROACH
    static int totalFruits(int[] arr) {

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(3)


        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {

                set.add(arr[j]);

                if (set.size() <= 2) {


                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);


                } else break;


            }
        }

        return maxLength;


    }

    // OPTIMAL APPROACH

    static int totalFruitsI(int[] fruits) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(2)

        int n=fruits.length;
        int maxLength=0;
        int left=0;
        int right=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<n;i++){

            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);


            if(map.size()<=2){

                int length=right-left+1;
                maxLength=Math.max(maxLength,length);
            }


            while (map.size()>2){

                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }

                left++;


            }

            right++;


        }

        return maxLength;


    }

    public static void main(String[] args) {

        // leeTCode->904

        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruits(arr));
        System.out.println(totalFruitsI(arr));

    }
}
