package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q7 {

    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    static void display(Node head){

        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node findMiddle(Node head){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)

        Node slow=head;
        Node fast=head;

        if(head==null) return null;

        while( fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }



    public static void main(String[] args) {

        // Q: find middle element of linked list for odd and right middle for even  (leeTCode->876)

        Node a =new Node(100);
        Node b=new Node(13);
        Node c=new Node(4);
        Node d=new Node(5);
        Node e=new Node(12);
        Node f=new Node(10);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        display(a);
        Node Ans=findMiddle(a);
        System.out.println(Ans.data);


    }
}
