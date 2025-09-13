package BitManipulation.InterviewQuestions;

import java.util.HashMap;

public class Q18 {


    // BRUTE FORCE APPROACH
    static int wonderfulSubstrings(String str) {

        int count = 0;
        int n = str.length();

        for (int i = 0; i < n; i++) {

            //  Time Complexity: O(n²)
            //  Space Complexity: O(10)->O(1)

            HashMap<Character, Integer> map = new HashMap<>();
            int oddCount = 0;


            for (int j = i; j < n; j++) {

                char ch = str.charAt(j);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.get(ch) % 2 == 0) {

                    oddCount--;
                } else oddCount++;

                if (oddCount <= 1) count++;


            }


        }

        return count;


    }


    static long wonderFulSubstringI(String word) {

        //  Time Complexity: O(n*10)=O(n)
        //  Space Complexity: O(10)->O(1)

        int[] count = new int[1024];
        int mask = 0;
        count[mask] = 1;
        long result = 0;

        for (char ch : word.toCharArray()) {

            int shift = ch - 'a';
            mask = mask ^ (1 << shift);

            result += count[mask];

            for (char c = 'a'; c <= 'j'; c++) {

                int newShift = c - 'a';
                int oneBitmask = mask ^ (1 << newShift);
                result += count[oneBitmask];


            }

            count[mask]++;


        }

        return result;


    }

    public static void main(String[] args) {

        // leeTCode->1915


        String word = "aabb";
        System.out.println(wonderfulSubstrings(word));
        System.out.println(wonderFulSubstringI(word));

    }
}
