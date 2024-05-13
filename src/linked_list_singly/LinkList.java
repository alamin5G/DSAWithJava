package linked_list_singly;


import org.w3c.dom.Node;

public class LinkList<T> {

    private Node head;
    private Node tail;
    private int size;

    LinkList(){
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<T>{
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    //add at first
    public void addFirst(T data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    //add to the last
    public void add(T data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //print the node data
    public void showData(){
        if (head == null){
            System.out.println("empty list");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    //delete from the first
    public void deleteFirst(){
        if(head == null){
            System.out.println("empty list");
        }else if(head.next == null){
            head = null;
            tail = null;
            size--;
        }else{
            head = head.next;
            size--;
        }
    }

    //delete last
    public void deleteLast(){
        if(head == null){
            System.out.println("empty list");
        }else if(head.next == null){
            head = null;
            tail = null;
            size--;
        }else{
            Node beforeLast = head;
            Node last = head.next;

            while(last.next != null){
                last = last.next;
                beforeLast = beforeLast.next;
            }
            beforeLast.next = null;
            tail = beforeLast;
            size--;
        }
    }

    public int getSize(){
        return size;
    }


    //main function
    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.addFirst(5); //5->null
        linkList.addFirst(9); //9->5->null
        linkList.addFirst(3); //3->9->5->null

        //print linkedlist data
        linkList.showData();
        System.out.println(linkList.getSize());
        System.out.println("after adding into the last");
        linkList.add(11); //3->9->5->11->null
        linkList.add(15); //3->9->5->11->15->null
        linkList.showData();
        System.out.println(linkList.getSize());

        System.out.println("after delete from the first");
        linkList.deleteFirst();
        linkList.showData();
        System.out.println(linkList.getSize());

        System.out.println("after delete from the last");
        linkList.deleteLast();
        linkList.deleteLast();

        linkList.showData();
        System.out.println(linkList.getSize());


    }

}