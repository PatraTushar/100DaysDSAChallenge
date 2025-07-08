package StackByStriver.conversion;

import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char op) {

        if (op == '+' || op == '-') return 1;
        else if (op == '*' || op == '/') return 2;
        else if (op == '^') return 3;
        else return 0;


    }

    @SuppressWarnings("StringConcatenationInLoop")

    static String evaluation(String infix) {

        // Time Complexity (TC): O(n)
        // Space Complexity (SC): O(n)

        int i = 0;
        int n = infix.length();
        Stack<Character> st = new Stack<>();
        String ans = "";

        while (i < n) {

            char ch = infix.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {

                ans += ch;
            } else if (ch == '(') {
                st.push(ch);

            } else if (ch == ')') {

                while (!st.isEmpty() && st.peek() != '(') {
                    ans += st.pop();
                }

                st.pop();

            }

            else {

                if(ch=='^'){

                    while (!st.isEmpty() && precedence(st.peek())>=precedence(ch)){
                        ans+=st.pop();

                    }

                }

                else {

                    while (!st.isEmpty() && precedence(st.peek())>precedence(ch)){
                        ans+=st.pop();

                    }

                }

                st.push(ch);


            }


            i++;


        }

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;


    }

    public static void main(String[] args) {

        String str = "a+b*(c^d-e)";
        String Ans = evaluation(str);
        System.out.println(Ans);

    }
}
