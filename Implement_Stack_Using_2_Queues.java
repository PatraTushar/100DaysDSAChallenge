package QueueByStriver.interviewQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    public static class Stack {



        Queue<Integer> original=new LinkedList<>();
        Queue<Integer> helper=new LinkedList<>();






        public void push(int val){

            // Time Complexity: O(1)
            // Space Complexity: O(1) (only 1 element is added)

            original.add(val);


        }

        public int pop(){

            // Time Complexity: O(n)
            // Space Complexity: O(1)

            if (original.isEmpty()) return -1;


            while (original.size()>1){

                helper.add(original.remove());
            }

            int top=original.remove();

            Queue<Integer> temp = original;
            original = helper;
            helper = temp;

            return top;

        }


        public int peek(){

            // Time Complexity: O(n)
            // Space Complexity: O(1)

            while (original.size()>1){

                helper.add(original.remove());
            }


            int top=original.remove();

            helper.add(top);


            Queue<Integer> temp = original;
            original = helper;
            helper = temp;

            return top;



        }

        public boolean isEmpty() {

            // Time Complexity: O(1)
            // Space Complexity: O(1)

            return original.isEmpty();
        }
    }

    public static void main(String[] args) {

        // Implement Stack Using 2 Queues


        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Stack is now: Top ➝ 30 ➝ 20 ➝ 10

        // Check top element
        System.out.println("Top: " + stack.peek()); // Output: 30

        // Pop the top element
        System.out.println("Popped: " + stack.pop()); // Output: 30

        // Check top again
        System.out.println("Top: " + stack.peek()); // Output: 20

        // Check if stack is empty
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: false

        // Pop remaining elements
        System.out.println("Popped: " + stack.pop()); // Output: 20
        System.out.println("Popped: " + stack.pop()); // Output: 10

        // Stack is now empty
        System.out.println("Is Empty: " + stack.isEmpty()); // Output: true
    }
}
