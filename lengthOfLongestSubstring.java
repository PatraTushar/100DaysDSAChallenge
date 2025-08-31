package TwoPointer_SlidingWindow;

import java.util.HashMap;

public class Q5 {


    // BRUTE FORCE APPROACH
    static int lengthOfLongestSubstring(String str) {

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(256)

        int n = str.length();
        int maxLength = Integer.MIN_VALUE;
        int[] hash = new int[255];

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                char ch = str.charAt(j);

                if (hash[ch] == 1) break;

                int length = j - i + 1;

                maxLength = Math.max(maxLength, length);
                hash[ch] = 1;


            }


        }

        return maxLength;
    }

    // OPTIMAL APPROACH

    static int lengthOfLongestSubstringI(String s) {


        //  Time Complexity: O(n)
        //  Space Complexity: O(n)


        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {

                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
                map.put(ch, i);

            } else {

                if (map.get(ch) >= left) {

                    left = map.get(ch) + 1;
                }

                map.put(ch,i);
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);



            }

            right++;


        }

        return maxLength;


    }


    public static void main(String[] args) {

        // leeTCode->3

        String str = "cadbzabcd";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstringI(str));
    }
}
