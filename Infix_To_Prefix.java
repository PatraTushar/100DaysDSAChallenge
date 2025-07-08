package StackByStriver.conversion;

import java.util.Stack;

public class InfixToPrefix {

    static int precedence(char op) {

        if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else if (op == '^') return 3;
        else return 0;

    }

    // step1 : Reverse the infix expression

    static String reverse(String str) {

        if (str.isEmpty()) return str;
        return reverse(str.substring(1)) + str.charAt(0);


    }

    // step:2 change '(' to ')'   and ')' to '(' of the reverse function

    static StringBuilder changeBrackets(String str) {

        String reverseAString = reverse(str);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reverseAString.length(); i++) {

            char ch = reverseAString.charAt(i);

            if (ch == '(') result.append(')');
            else if (ch == ')') result.append('(');
            else result.append(ch);
        }

        return result;


    }

    // step:3 conversion of infix to postfix

    @SuppressWarnings("StringConcatenationInLoop")
    static String conversion(String str) {

        //Time Complexity (TC): O(n)
        // Space Complexity (SC): O(n)

        StringBuilder fullyRev = changeBrackets(str);

        int i = 0;
        int n = fullyRev.length();
        Stack<Character> st = new Stack<>();
        String ans = "";

        while (i < n) {

            char ch = fullyRev.charAt(i);

            if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                ans += ch;
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {

                    ans += st.pop();

                }

                st.pop();
            } else {

                if (ch == '^') {

                    while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                        ans += st.pop();
                    }

                }
                else {

                    while (!st.isEmpty() && precedence(st.peek()) > precedence(ch)) {
                        ans += st.pop();
                    }


                }
                    st.push(ch);
                }

                i++;
            }

            while (!st.isEmpty()) {
                ans += st.pop();
            }


            return reverse(ans);
        }



    public static void main(String[] args) {

        String infix = "(A+B)*C-D+F";
        System.out.println(conversion(infix));


    }
}
