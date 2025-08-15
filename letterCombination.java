package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q6 {

    static List<String> letterCombination(String str, String ans, List<String> list) {

        // It is Parametrized Recursion

        // Time Complexity (TC): O(kⁿ)       n->Number of digits in the input string   k->Maximum number of letters a digit can map to (max 4)
        // Space Complexity (SC): O(n) (recursion stack only)


        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (str.isEmpty()) {
            list.add(ans);
            return list;
        }

        int digits = str.charAt(0) - '0';

        if (digits < 2 || digits > 9) return new ArrayList<>();

        String letters = phone[digits];


        for (int i = 0; i < letters.length(); i++) {

            letterCombination(str.substring(1), ans + letters.charAt(i), list);


        }

        return list;


    }


    static List<String> letterCombinationI(String digits, String ans) {

        // Time Complexity: O(3ⁿ × 4ᵐ)
        // Space Complexity: O(3ⁿ × 4ᵐ × k)

        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


        List<String> list = new ArrayList<>();

        if (digits.isEmpty()) {
            list.add(ans);
            return list;
        }

        int d = digits.charAt(0) - '0';
        String letters = phone[d];

        for (int i = 0; i < letters.length(); i++) {

            List<String> result = letterCombinationI(digits.substring(1), ans + letters.charAt(i));
            list.addAll(result);
        }


        return list;


    }

    static List<String> pad(String digits) {


        if(digits.isEmpty()) return new ArrayList<>();

        return letterCombination(digits, "",new ArrayList<>());


    }

    public static void main(String[] args) {


        String str = "23";
        List<String> ans = letterCombination(str, "", new ArrayList<>());
        System.out.println(ans);
        List<String> ans1=pad(str);
        System.out.println(ans1);
    }
}
