package linked_list_singly;

public class LinkList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    LinkList(){
        head = null;
        tail = null;
        size = 0;
    }

    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    //add at first
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
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
        Node<T> newNode = new Node<>(data);
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
            Node<T> temp = head;
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
            Node<T> beforeLast = head;
            Node<T> last = head.next;

            while(last.next != null){
                last = last.next;
                beforeLast = beforeLast.next;
            }
            beforeLast.next = null;
            tail = beforeLast;
            size--;
        }
    }

    //insert at given position
   public void insertAt(int position, T data){
        if (head == null){
            System.out.println("empty list");
            return;
        }

       Node<T> newNode = new Node<>(data);
        if(position == 0){
            newNode.next = head;
            head = newNode;
        }else if(position == size){
            tail.next = newNode;
            tail = newNode;
        }else {
            Node<T> temp = head;
            int count = 0;
            while(count < position -1){
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }

        size++;
   }
    //delete at given position
    public void deleteAt(int position){
        if (head == null){
            System.out.println("empty list");
            return;
        }

        if (position == 0 && head.next == null){
            head = null;
            tail = null;
        }else if(position == 0) {
            head = head.next;
        }else{
            Node<T> temp = head;
            int count = 0;
            while(count < position -1){
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
    }
    //get data at given position
    public T getDataAt(int position){
        if (head == null){
            T result = (T) "empty list";
            return result;
        }
        Node<T> temp = head;
        int count = 0;
        while(count < position){
            temp = temp.next;
            count++;
        }
        return temp.data;
    }

    //find data
    public boolean find(T keyData){
        Node<T> temp = head;
        while(temp != null){
            if(temp.data == keyData){
                return true;
            }
            temp = temp.next;
        }
        return false;
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
        System.out.println("after insert at (0) ");
        linkList.insertAt(0, 1); //1->9->5->11->15->null
        linkList.showData();
        System.out.println(linkList.getSize());
         System.out.println("after insert at (last) ");
        linkList.insertAt(linkList.getSize(), 7); //1->9->5->11->15->7->null
        linkList.showData();
        System.out.println(linkList.getSize());
         System.out.println("after insert at (3) ");
        linkList.insertAt(3, 2); //1->9->5->2->11->15->7->null
        linkList.showData();
        System.out.println(linkList.getSize());

        System.out.println("after delete at (0) ");
        linkList.deleteAt(0); //9->5->2->11->15->7->null
        linkList.showData();
        System.out.println(linkList.getSize());
        System.out.println("after delete at (3) ");
        linkList.deleteAt(3); //9->5->2->15->7->null
        linkList.showData();
        System.out.println(linkList.getSize());

        System.out.println("get data from at (3) : " + linkList.getDataAt(0)); //9->5->2->15->7->null
        System.out.println("find data  : " + linkList.find(8));
    }

}