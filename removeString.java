package RecursionByStriver.InterviewQuestions;

public class Q2 {

    static String removeString(String str, String ans) {

        // Time Complexity: O(n)
        //Space Complexity: O(n)

        // it is parametrized recursion

        if (str.isEmpty()) {

            return ans;
        }

        char ch = str.charAt(0);

        if (!str.startsWith("apple")) {

            return removeString(str.substring(1), ans + ch);
        } else {

            return removeString(str.substring(5), ans);
        }


    }

    static String removeStringI(String str){

        // Time Complexity: O(n)
        //Space Complexity: O(n)

        // it is functional recursion

        if(str.isEmpty()) return "";


        char ch=str.charAt(0);

        if(!str.startsWith("apple")) return ch + removeStringI(str.substring(1));

        else return removeStringI(str.substring(5));


    }

    public static void main(String[] args) {

        String str = "bapplecd";
        String Ans = removeString(str, "");
        System.out.println(Ans);
        String str1="bapplecdd";
        String Ans1=removeStringI(str1);
        System.out.println(Ans1);
    }
}
