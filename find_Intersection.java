package linkedListByKK.SinglyLinkedList.InterviewQuestion;

import OopsByKK.AccessModifier.Public.A;

public class Q6 {

    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    static void display(Node head1,Node head2){

        Node temp1=head1;
        Node temp2=head2;

        while (temp1!=null){
            System.out.print(temp1.data +" ");
            temp1=temp1.next;
        }
        System.out.println();

        while (temp2!=null){
            System.out.print(temp2.data +" ");
            temp2=temp2.next;
        }
        System.out.println();

    }

    static Node findIntersection(Node headA,Node headB){

        //Time Complexity: O(n + m)
        //Space Complexity: O(1)

        Node temp1=headA;
        Node temp2=headB;

        int length1=0;
        int length2=0;

        while (temp1!=null){
            length1++;
            temp1=temp1.next;
        }

        while (temp2!=null){
            length2++;
            temp2=temp2.next;
        }

        if(length1>length2){

            return findIntersection(headB,headA);

        }

        Node slow=headA;
        Node fast=headB;

        int lengthDiff=length2-length1;

        for(int i=0;i<lengthDiff;i++){
            fast=fast.next;
        }

        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;






    }



    public static void main(String[] args) {

        // Q: Intersection of 2 linked list  (leeTCode->160)

        Node a=new Node(87);
        Node b=new Node(100);
        Node c=new Node(13);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(12);
        Node g=new Node(10);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;

        Node h=new Node(90);
        Node i=new Node(9);
        h.next=i;
        i.next=e;


        display(a,h);
        Node Ans=findIntersection(a,h);
        System.out.println(" Intersection of both linked list is " +Ans.data);

    }
}
