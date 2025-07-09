package StackByStriver.conversion;

import java.util.Stack;

public class PostfixToInfix {

    static String evaluation(String postfix){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(n)


        Stack<String> st=new Stack<>();

        int i=0;
        int n=postfix.length();

        while (i<n){

            char ch=postfix.charAt(i);

            if(ch>='A' && ch<='Z'  || ch>='a' && ch<='z' || ch>='0' && ch<='9'){

                st.push(ch +"");
            }

            else {

                String val2=st.pop();
                String val1=st.pop();
                String result="(" + val1 + ch + val2 + ")";
                st.push(result);

            }
            i++;
        }

        return st.peek();


    }

    public static void main(String[] args) {

        String postfix="AB-DE+F*/";
        System.out.println(evaluation(postfix));






    }
}
