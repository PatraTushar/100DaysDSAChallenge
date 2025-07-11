package StackByStriver.interviewQuestions;

import java.util.Locale;
import java.util.Stack;

public class minStackI {

    // Optimal Approach

    Stack<Long> st = new Stack<>();
    long min = Integer.MAX_VALUE;


    public void push(int val) {

        // Time Complexity : O(1)
        // Space Complexity : O(n)

        if (st.isEmpty()) {

            min = val;
            st.push((long) val);
        } else {

            if (val > min) st.push((long)val);
            else {
                st.push(2L * val - min);
                min = val;
            }
        }

    }

    public void pop() {

        // Time Complexity : O(1)
        // Space Complexity : O(n)

        if (st.isEmpty()) {

            System.out.println(" stack is empty ");
            return;

        }

        long top = st.peek();
        st.pop();

        if (top < min) {

            min = 2 * min - top;

        }

    }

    public int top() {

        // Time Complexity : O(1)
        // Space Complexity : O(n)

        if(st.isEmpty()){
            return -1;
        }

        long top=st.peek();

        if(min < top) return (int) top;

        return (int) min;

    }

    public int getMin(){

        // Time Complexity : O(1)
        // Space Complexity : O(n)

        return (int) min;
    }


    public static void main(String[] args) {

        minStackI m=new minStackI();

        // Push some values
        m.push(12);
        m.push(15);
        m.push(10);


        // Get minimum value
        System.out.println("Minimum so far: " + m.getMin()); // Should print 10

        // Pop top element
        m.st.pop(); // Removes 10

        System.out.println("Minimum so far: " + m.getMin());

        // Get top and min after pop
        System.out.println("Top after pop: " + m.top());   // Should print 15
        System.out.println("Min after pop: " + m.getMin()); // Should print 12



    }
}
