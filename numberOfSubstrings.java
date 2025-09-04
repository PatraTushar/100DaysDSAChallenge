package TwoPointer_SlidingWindow;

import java.util.HashMap;

public class Q9 {

    // BRUTE FORCE APPROACH
    static int numberOfSubstrings(String s) {

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(1)


        int n = s.length();
        int totalSubstrings = 0;


        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() == 3) {

                    totalSubstrings++;


                }


            }


        }

        return totalSubstrings;


    }


    static int numberOfSubstringsI(String s) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)

        int n = s.length();
        int numberOfStrings = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() == 3) {

                numberOfStrings+=n-right;
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
                left++;



            }







        }

        return numberOfStrings;

    }

    public static void main(String[] args) {

        // leeTCode->1358

        String s = "bbacba";
        System.out.println(numberOfSubstrings(s));
        System.out.println(numberOfSubstringsI(s));
    }
}
