package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q25 {

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
            System.out.print(temp.data +" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static Node duplicateII(Node head){

        Node dummy=new Node(0);
        Node prev=dummy;
        dummy.next=head;

        while (head!=null){

            if(head.next!=null && head.data==head.next.data){
                while (head.next!=null && head.data==head.next.data){
                    head=head.next;
                }
                prev.next=head.next;

            }

            else {
                prev=prev.next;

            }

            head=head.next;

        }

        return dummy.next;

    }

    public static void main(String[] args) {


        // Q: Remove duplicate from the sorted list II (leeTCode->82)

        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(3);
        Node e=new Node(4);
        Node f=new Node(4);
        Node g=new Node(5);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;

        display(a);
        Node ans=duplicateII(a);
        display(ans);





    }
}
