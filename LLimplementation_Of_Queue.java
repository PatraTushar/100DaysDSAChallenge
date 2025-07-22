package QueueByStriver.basics;

import java.util.NoSuchElementException;

public class llImplementationOfQueue {

    public static class Queue {


        public static class Node {

            int data;
            Node next;

            Node(int data) {

                this.data = data;
            }
        }

        Node head = null;
        Node tail = null;
        int size = 0;

        public void add(int data) {

            // Time Complexity: O(1)
            // Space Complexity: O(1)

            Node newNode = new Node(data);

            if (size == 0) {

                head = tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;

            }

            size++;


        }

        public int remove() {

            // Time Complexity: O(1)
            //Space Complexity: O(1)

            if (size == 0) {
                throw new NoSuchElementException(" Nothing can be removed Queue is empty ");
            }

            int top = head.data;
            head = head.next;
            size--;
            if (size == 0) tail = null;
            return top;
        }

        public int peek() {

            // Time Complexity: O(1)
            //Space Complexity: O(1)

            if (size == 0) {
                throw new NoSuchElementException(" Nothing can be peek Queue is empty ");
            }

            return head.data;

        }

        public boolean isEmpty() {

            // Time Complexity: O(1)
            //Space Complexity: O(1)

            if (size == 0) {
                return true;
            } else {
                return false;
            }

        }

        public int size() {

            // Time Complexity: O(1)
            //Space Complexity: O(1)

            return size;
        }


        public void display() {

            // Time Complexity: O(n)
            //Space Complexity: O(1)

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }

    }


    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.display(); // 10 20 30 40 50
        queue.remove();
        queue.display(); //  20 30 40 50
        System.out.println(queue.peek()); // 20
        System.out.println(queue.size()); // 4
        System.out.println(queue.isEmpty()); // false


    }
}
