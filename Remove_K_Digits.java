package StackByStriver.interviewQuestions;

import OopsByKK.AccessModifier.Public.A;

import java.util.Stack;

public class Q15 {

    static String removeKDigits(String num,int k){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(n)

        char[] digits=num.toCharArray();
        Stack<Character> st=new Stack<>();

        for(char ele : digits){

            while (!st.isEmpty() && k>0 && st.peek()>ele){
                st.pop();
                k--;
            }

            st.push(ele);
        }

        while (!st.isEmpty() && k>0){
            st.pop();
            k--;
        }


        StringBuilder sb=new StringBuilder();

        for(char ele : st){

            sb.append(ele);
        }

        while (sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }


        return sb.length()==0 ? "0" : sb.toString();




    }

    public static void main(String[] args) {

        String str="1432219";
        int k=3;
        String Ans=removeKDigits(str,k);
        System.out.println(Ans);


    }
}
