package StackByStriver.conversion;


import java.util.Stack;

public class PrefixToInfix {

    static String evaluation(String prefix){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(n)

        int i=prefix.length()-1;

        Stack<String> st=new Stack<>();

        while (i>=0){

            char ch=prefix.charAt(i);


            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || ch>='0' && ch<='9'){

                st.push(ch +"");
            }

            else {

                String val1=st.pop();
                String val2=st.pop();
                String result="("+ val1 + ch + val2 +")";
                st.push(result);
            }

            i--;



        }

        return st.peek();
    }

    public static void main(String[] args) {

        String prefix="*+PQ-MN";
        System.out.println(evaluation(prefix));


    }
}
