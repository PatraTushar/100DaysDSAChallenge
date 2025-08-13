package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q4 {

    static List<String> AllSubsets(String str, String Ans, List<String> list) {

        //  Time Complexity: O(2^n)
        // Space Complexity: O(2^n * n)     You're storing 8 strings — and strings take memory per character

        // It is Parametrized Recursion

        if (str.isEmpty()) {

            list.add(Ans);
            return list;

        }

        char ch = str.charAt(0);

        AllSubsets(str.substring(1), Ans + ch, list);
        AllSubsets(str.substring(1), Ans, list);


        return list;


    }

    static List<String> AllSubsetsI(String str, String Ans) {

        //  Time Complexity: O(2^n * n)
        // Space Complexity: O(2^n * n)     You're storing 8 strings — and strings take memory per character

        // It is Functional Recursion

        List<String> list = new ArrayList<>();

        if (str.isEmpty()) {
            list.add(Ans);
            return list;

        }

        char ch = str.charAt(0);

        List<String> add = AllSubsetsI(str.substring(1), Ans + ch);
        List<String> DoNotAdd = AllSubsetsI(str.substring(1), Ans);

        list.addAll(add);
        list.addAll(DoNotAdd);
        return list;
    }


    static List<String> subsetsAscii(String str, String Ans, List<String> list) {


        //  Time Complexity: O(3^n)
        // Space Complexity: O(3^n * n)     You're storing 8 strings — and strings take memory per character

        // It is Parametrized Recursion

        if (str.isEmpty()) {

            list.add(Ans);
            return list;

        }

        char ch = str.charAt(0);

        subsetsAscii(str.substring(1), Ans + ch, list);
        subsetsAscii(str.substring(1), Ans, list);
        subsetsAscii(str.substring(1), Ans + (ch + 0), list);


        return list;


    }





    public static void main(String[] args) {

        String str = "abc";
        String str2 = "ab";
        List<String> subsets = AllSubsets(str, "", new ArrayList<>());
        System.out.println(subsets);
        List<String> subsetsI = AllSubsetsI(str, "");
        System.out.println(subsetsI);
        List<String> subsetsAscii = subsetsAscii(str2, "", new ArrayList<>());
        System.out.println(subsetsAscii);





    }
}
