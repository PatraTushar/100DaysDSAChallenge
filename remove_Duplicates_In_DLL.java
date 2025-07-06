package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q39 {


        public static class Node{

            Node prev;
            int data;
            Node next;

            Node(int data){

                this.data=data;
            }
        }

        static Node removeDuplicatesInDLL(Node head){

            //Time Complexity (TC): O(N)
            //Space Complexity (SC): O(1)

            Node temp=head;

            while (temp!=null && temp.next!=null){

                Node nextNode=temp.next;

                    while (nextNode!=null && nextNode.data==temp.data){
                        nextNode=nextNode.next;
                    }

                    temp.next=nextNode;
                    if(nextNode!=null) nextNode.prev=temp;
                    temp=temp.next;



            }

            return head;




        }

        static void display(Node head){

            Node temp=head;
            while (temp!=null){
                System.out.print(temp.data +" ");
                temp=temp.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {

            // Delete All occurrences of key in DLL

            Node a=new Node(1);
            Node b=new Node(1);
            Node c=new Node(1);
            Node d=new Node(2);
            Node e=new Node(3);
            Node f=new Node(3);
            Node g=new Node(4);

            a.prev=null;
            a.next=b;
            b.prev=a;
            b.next=c;
            c.prev=b;
            c.next=d;
            d.prev=c;
            d.next=e;
            e.prev=d;
            e.next=f;
            f.prev=e;
            f.next=g;
            g.prev=f;
            g.next=null;

            display(a);
           // int key=10;
            Node Ans=removeDuplicatesInDLL(a);
            display(Ans);







        }
    }


