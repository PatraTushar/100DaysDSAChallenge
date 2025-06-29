package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q12 {

    public static class Node{

        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

    static Node cycleInALinkedListII(Node head){

        //Time Complexity: O(N)
        //Space Complexity: O(1)

        Node slow=head;
        Node fast=head;

        if(head==null || head.next==null) return null;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) break;
        }

        if(fast==null || fast.next==null) return null;



        slow=head;

        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static int getIndex(Node head, Node target) {
        int index = 0; // Start indexing from 1
        Node temp = head;
        while (temp != null) {
            if (temp == target) return index;
            temp = temp.next;
            index++;
        }
        return -1; // Should never reach here if the node exists
    }

    public static void main(String[] args) {

        // Q:  Cycle in a linked list II (leeTCode-->142)

        Node a=new Node(3);
        Node b=new Node(2);
        Node c=new Node(0);
        Node d=new Node(-4);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=b;




        Node e=new Node(1);
        Node f=new Node(2);
        e.next=f;
        f.next=e;

        Node g=new Node(1);


        Node Ans=cycleInALinkedListII(a);


        if(Ans!= null){

            int cycleIndex=getIndex(a,Ans);

            System.out.println( " tail connects to node index " +cycleIndex);

        }

        else {
            System.out.println(" No cycle found ");
        }

    }
}
