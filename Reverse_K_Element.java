package QueueByStriver.interviewQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q1 {

    static Queue<Integer> reverseKElement(Queue<Integer> q, int k) {

        //Time Complexity: O(n)
        //Space Complexity: O(k)

        if (q.size() < k) return q;

        Stack<Integer> st = new Stack<>();


        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }


        while (!st.isEmpty()){
            q.add(st.pop());
        }

        int remainingToReverse=q.size()-k;

        for(int i=0;i<remainingToReverse;i++){

            q.add(q.remove());
        }

        return q;




    }

    public static void main(String[] args) {

        // Reverse First k Element Of Queue

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;

        Queue<Integer> ans = reverseKElement(q, k);
        System.out.println(ans);
    }
}
