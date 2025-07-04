package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q27 {

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

    static Node reverseBetween(Node head, int left, int right) {

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)

        if(head==null) return null;


        Node pointer1 = head;



        for (int i = 1; i < left-1 ; i++) {

            pointer1 = pointer1.next;

        }

        Node pointer2;

        if(left==1){
            pointer2=pointer1;
        }

        else {
            pointer2=pointer1.next;
        }




        Node prev = null;
        Node curr = pointer2;
        Node Agla;


        for (int i = 1; i <= right-left + 1; i++) {

            Agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Agla;

        }

        if(left==1){
            pointer1.next=curr;
            return prev;
        }
        else {

            pointer1.next = prev;
            pointer2.next = curr;
        }


        return head;





    }

    public static void main(String[] args) {

        // Q: reverse linked list II (leeTCode->92)

        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        display(a);

        Node Ans=reverseBetween(a,2,4);
        display(Ans);

    }
}
