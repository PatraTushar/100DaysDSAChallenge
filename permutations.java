package RecursionByStriver.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q5 {

    static List<String> permutations(String str, String Ans, List<String> list) {

        // Time Complexity: O(n × n!)
        //Space Complexity: O(n × n!)

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


    static int permutationsCount(String str, String Ans, List<String> list) {

        // Time Complexity: O(n × n!)
        //Space Complexity: O(n)

        if (str.isEmpty()) {
            return 1;
        }

        int count=0;
        char ch = str.charAt(0);

        for (int i = 0; i <= Ans.length(); i++) {

            String first = Ans.substring(0, i);
            String second = Ans.substring(i);
            count= count +  permutationsCount(str.substring(1), first + ch + second, list);

        }

        return count;


    }


    public static void main(String[] args) {

        String str = "abc";
        List<String> list = permutations(str, "", new ArrayList<>());
        System.out.println(list);
        System.out.println(permutationsCount(str,"",new ArrayList<>()));
    }
}
