package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q10 {

    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    static void display(Node head){
        Node temp=head;

        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

        System.out.println();
    }

    static Node deleteLeftMiddle(Node head){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)

        if(head==null) return null;
        if(head.next==null) return head;
        if(head.next.next==null) return head.next;

        Node slow=head;
        Node fast=head.next.next;



        while ( fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=slow.next.next;

        return head;


    }


    public static void main(String[] args) {

        // Q: Delete the middle element of linked list for odd and left middle for even

        Node a=new Node(1);
        Node b=new Node(5);
        Node c=new Node(10);
        Node d=new Node(13);
        Node e=new Node(12);
        Node f=new Node(20);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        display(a);
        Node Ans=deleteLeftMiddle(a);
        display(Ans);



    }
}
