package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q17 {

    public static class Node{

        int data;
        Node next;

        Node(int data){

            this.data=data;
        }

    }


        static Node duplicateI(Node head){

            //Time Complexity: O(n)
            //Space Complexity: O(1)

            Node dummy=new Node(Integer.MIN_VALUE);
            Node t=dummy;
            Node temp=head;

            while (temp!=null){

                if(t.data !=temp.data){

                    t.next=temp;
                    t=temp;
                    temp=temp.next;
                }

                else {

                    while (t.data ==temp.data){
                        temp=temp.next;
                        if(temp==null) break;

                    }
                    t.next=temp;


                }
            }

            return dummy.next;





        }

      static   void display(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
            System.out.println();


        }




    public static void main(String[] args) {

        // Q : Remove duplicate from sorted list I  (leeTCode->83)

        Node a=new Node(1);
        Node b=new Node(1);
        Node c=new Node(2);
        Node d=new Node(3);
        Node e=new Node(3);
        Node f=new Node(3);
        Node g=new Node(4);
        Node h=new Node(4);
        Node i=new Node(5);
        Node j=new Node(6);
        Node k=new Node(6);



        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=k;

        display(a);
        Node Ans=duplicateI(a);
        display(Ans);







    }
}
