package TwoPointer_SlidingWindow;

import java.util.HashMap;

public class Q8 {


    // BRUTE FORCE APPROACH
    static int KLongestSubstring(String s, int k) {

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(k)

        int n = s.length();
        int maxLength = -1;


        for (int i = 0; i < n; i++) {

            HashMap<Character, Integer> map = new HashMap<>();


            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() == k) {
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }

               else if(map.size()>k) break;


            }


        }

        return maxLength;
    }

    // OPTIMAL APPROACH

    static int KLongestSubstringI(String s, int k) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(k)

        int n = s.length();
        int maxLength = -1;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {


            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            if (map.size() == k) {

                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }

            right++;

            while (map.size() > k) {

                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);



                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }


                left++;
            }


        }

        return maxLength;

    }

    public static void main(String[] args) {

        // leeTCode->340

        String s = "aaabbccd";
        int k = 2;
        System.out.println(KLongestSubstring(s, k));
        System.out.println(KLongestSubstringI(s, k));


    }
}
