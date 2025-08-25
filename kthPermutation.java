package RecursionByStriver.BackTracking;

import java.util.*;

public class Q5 {

    // BRUTEFORCE APPROACH
    static String convertToString(int n) {




        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            sb.append(i);
        }

        return sb.toString();
    }

    static List<String> permutations(String str, String Ans, List<String> list) {

        if (str.isEmpty()) {
            list.add(Ans);
            return list;
        }

        char ch = str.charAt(0);

        for (int i = 0; i <= Ans.length(); i++) {

            String first = Ans.substring(0, i);
            String second = Ans.substring(i);
            permutations(str.substring(1), first + ch + second, list);

        }

        return list;


    }

    static String kthPermutation(int n, int k) {

        // Time Complexity: O(n! × n + n! log n!)
        //Space Complexity: O(n!)

        String ans = convertToString(n);

        List<String> list = permutations(ans, "", new ArrayList<>());

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {

            if (i == k - 1) {

                return list.get(i);


            }


        }


        return "";

    }


    // optimal solution
    static String getPermutation(int n,int k){

        // Time Complexity: O(n²)
       // Space Complexity: O(n)

        List<Integer> Number=new ArrayList<>();

        for(int i=1;i<=n;i++){

            Number.add(i);
        }

        int[] factorial=new int[n];
        factorial[0]=1;

        for(int i=1;i<n;i++){

            factorial[i]=factorial[i-1]*i;
        }


        k--;

        StringBuilder sb=new StringBuilder();

        for(int i=n;i>=1;i--){

            int fact = factorial[i - 1];
            int index = k / fact;
            sb.append(Number.get(index));
            Number.remove(index);
            k = k % fact;


        }


        return sb.toString();




    }






    public static void main(String[] args) {

        int n=3;
        int k=3;

        String ans=getPermutation(n,k);
        System.out.println(ans);


    }
}
