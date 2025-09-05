package TwoPointer_SlidingWindow;

public class Q10 {

    static int characterReplacement(String s, int k) {

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(26)=O(1)

        int n = s.length();
        int maxLength = 0;


        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int maxFreq = 0;


            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'A']++;

                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
                int changes = (j - i + 1) - maxFreq;

                if (changes <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else break;


            }
        }

        return maxLength;

    }


    static int characterReplacementI(String s, int k) {

        //  Time Complexity: O(n)
        //  Space Complexity: O(26)=O(1)


        int n = s.length();
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < n; i++) {

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);


            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);


            right++;
        }

        return maxLength;

    }

    public static void main(String[] args) {

        // leeTCode->424

        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacementI(s, k));
    }
}
