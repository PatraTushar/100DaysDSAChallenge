package linkedListByStriver.SinglyLinkedList.InterviewQuestion;

public class Q29 {

    public static class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

    }


    static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode Agla;

        while (curr != null) {

            Agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Agla;
        }

        return prev;
    }

    static ListNode findKthNode(ListNode head, int k){

        ListNode temp=head;

        for(int i=1;i<k;i++){

            if (temp == null) return null;

            temp=temp.next;


        }

        return temp;


    }

    static ListNode reverseKthNode(ListNode head, int k){

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)

        ListNode temp=head;

        ListNode prevNode=null;

        while (temp!=null){

            ListNode kthNode=findKthNode(temp,k);

            if(kthNode==null){

                if(prevNode!=null){

                    prevNode.next=temp;


                }

                break;

            }

            ListNode nextNode=kthNode.next;
            kthNode.next=null;

          reverse(temp);



            if(temp==head){

                head=kthNode;

            }
            else {

                prevNode.next=kthNode;


            }

            prevNode=temp;
            temp=nextNode;
        }

        return head;

    }

    static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {

            System.out.print(temp.data + " ");
            temp = temp.next;

        }

        System.out.println();

    }


    public static void main(String[] args) {

        // Reverse nodes in k group

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(10);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        int k=3;

        display(a);
        ListNode Ans=reverseKthNode(a,k);
        display(Ans);


    }
}
