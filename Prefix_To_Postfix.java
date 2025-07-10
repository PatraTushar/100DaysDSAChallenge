package StackByStriver.conversion;

import java.util.Stack;

public class PrefixToPostfix {

    static String evaluation(String prefix){

        Stack<String> st=new Stack<>();
        int i=prefix.length()-1;


        while (i>=0){

            // Time Complexity (TC): O(n)
            //Space Complexity (SC): O(n)


            char ch=prefix.charAt(i);

            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || ch>='0' && ch<='9'){

                st.push(ch +"");
            }

            else {

                String val1=st.pop();
                String val2=st.pop();
                String result=  val1 + val2 + ch ;
                st.push(result);
            }
            i--;

        }

        return st.peek();
    }

    public static void main(String[] args) {

        String prefix="/-AB*+DEF";
        System.out.println(evaluation(prefix));
    }
}
