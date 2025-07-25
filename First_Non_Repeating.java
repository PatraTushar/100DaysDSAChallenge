package QueueByStriver.interviewQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

    static String firstNonRepeating (String str){

        // Time Complexity: O(n)
        // Space Complexity: O(n)

        char[] s=str.toCharArray();
        Queue<Character> q=new LinkedList<>();
        int[] freq=new int[26];
        StringBuilder sb=new StringBuilder();

        for(char ch:s){

            freq[ch - 'a']++;
            q.add(ch);


            while (!q.isEmpty() && freq[q.peek()-'a']>1){

                q.remove();
            }

            if(q.isEmpty()){

                sb.append('#');

            }

            else {

                sb.append(q.peek());
            }


        }

        return sb.toString();
    }


    public static void main(String[] args) {

        // Stream first non-Repeating

        String str="ababcddce";

        System.out.println(firstNonRepeating(str));




    }
}
