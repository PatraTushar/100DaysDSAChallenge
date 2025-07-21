package QueueByStriver.basics;

import java.util.NoSuchElementException;

public class arrayImplementationOfQueue {

    public static class Queue {

        int[] arr = new int[10];
        int size = 0;
        int front = -1;
        int rear = -1;

        public void add(int data) {

            //Time Complexity:O(1)
            //Space Complexity:O(1)

            if (size == arr.length) {
                System.out.println(" insertion not possible ");
                return;
            }

            if (front == -1) {

                front = rear = 0;

            }


            arr[rear] = data;
            rear++;
            size++;


        }

        public int remove() {

            //Time Complexity:O(1)
            //Space Complexity:O(1)

            if (front == -1) {
                throw new NoSuchElementException(" queue is empty ");
            }

            int val = arr[front++];
            size--;

            if (size == 0) front = rear = -1;

            return val;


        }


        public int peek() {

            //Time Complexity:O(1)
            //Space Complexity:O(1)

            if (size == 0) {
                throw new NoSuchElementException(" queue is empty ");
            }

            return arr[front];


        }

        void display() {

            //Time Complexity:O(n)
            //Space Complexity:O(1)

            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }

            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }


        public int size() {

            //Time Complexity:O(1)
            //Space Complexity:O(1)

            if (size == 0) {
                return 0;
            }

            return size;

        }


        public boolean isEmpty() {

            //Time Complexity:O(1)
            //Space Complexity:O(1)

            return size == 0;
        }

    }


    public static void main(String[] args) {

        Queue q = new Queue();

        q.display();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.display();   // 1 2 3 4
        q.remove();
        q.display();   // 2 3 4
        System.out.println(q.peek());  // 2

    }
}
