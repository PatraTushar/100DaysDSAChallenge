package linkedListByKK.SinglyLinkedList.Basics;

public class implementationOfLL {

    public static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public static class LinkedList {

        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtTail(int data) {

            Node newNode = new Node(data);

            if (head == null) {

                head = newNode;

            } else {

                tail.next = newNode;

            }

            tail = newNode;
            size++;

        }

        void insertAtHead(int data) {

            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {

                newNode.next = head;
                head = newNode;


            }

            size++;
        }


        void insert(int idx, int data) {

            if(idx<0 || idx>size){

                throw new IndexOutOfBoundsException(" invalid index ");

            }

            if(idx==0){

                insertAtHead(data);
                return;
            }

            if(idx==size){
                insertAtTail(data);
                return;
            }



            Node newNode=new Node(data);
            Node temp=head;

            for(int i=0;i<idx-1;i++){

                temp=temp.next;

            }

            Node afterNode=temp.next;
            temp.next=newNode;
            newNode.next=afterNode;

            size++;

        }

       public int getAt(int idx){

            Node temp=head;

            if(idx<0 || idx==size){

                throw new IndexOutOfBoundsException(" invalid index ");

            }

            for(int i=0;i<idx;i++){
                temp=temp.next;

            }

            return temp.data;
        }

       public void delete(int idx){

            Node temp=head;

            if(idx<0 || idx==size){
                throw new IndexOutOfBoundsException(" invalid index ");
            }

            if(idx==0){
                head=head.next;

                if(head==null){
                    size--;
                    return ;
                }

                size--;
                return;
            }

            for(int i=0;i<idx-1;i++){

                temp=temp.next;
            }

            temp.next=temp.next.next;
            size--;


        }

        void display(){

            Node temp=head;

            while (temp!=null){
                System.out.print(temp.data +" ");
                temp=temp.next;
            }

            System.out.println();
        }



    }

    public static void main(String[] args) {

        LinkedList ll=new LinkedList();
        ll.insertAtTail(10);
        ll.insertAtTail(20);
        ll.insertAtTail(30);
        ll.insertAtTail(40);
        ll.insertAtTail(50);
        ll.display(); // 10 20 30 40 50
        ll.insertAtHead(100);
        ll.display(); //100 10 20 30 40 50
        ll.insert(3,500);
        ll.display();  //100 10 20 500 30 40 50
        System.out.println(ll.getAt(4)); //30
        ll.delete(5);
        ll.display();  // 100 10 20 500 30 50




    }



}
