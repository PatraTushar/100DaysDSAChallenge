package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q31 {

    public static class Node {

        int data;
        Node next;

        Node(int data) {

            this.data = data;
        }
    }

    static Node AddNumbers(Node head1, Node head2) {

        // Time Complexity (TC): O(max(N, M))
        //Space Complexity (SC): O(max(N, M))
        //Where:
        //N = number of nodes in head1
        //M = number of nodes in head2



        Node dummy = new Node(-1);
        Node curr = dummy;
        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {
            int val1 = (head1 != null) ? head1.data : 0;
            int val2 = (head2 != null) ? head2.data : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new Node(digit);
            curr = curr.next;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }

        return dummy.next;

    }



    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {

        // Add Two Numbers  (leeTCde->2)

        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(6);
        Node d = new Node(2);
         Node e = new Node(6);

        a.next = b;
        b.next = c;
        c.next = d;
         d.next=e;


        Node f = new Node(4);
        Node g = new Node(1);
        Node h = new Node(8);
        Node i = new Node(5);
        Node j = new Node(2);

        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        Node Ans = AddNumbers(a, f);
        display(Ans);





    }
}
