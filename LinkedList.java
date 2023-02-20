public class LinkedList {
    Node head;
    
    // Prints LinkedList
    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Adds value to end of LinkedList
    public void add(int data) {
        Node current = this.head;
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }
    
    // Adds value to given index of LinkedList. If index is out of bounds, it adds value to last index of LinkedList.
    public void add(int data, int index) {
        Node current = this.head;
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        for (int i = 0; i < index-1; i++) {
            if (current.next == null)
                break;
            current = current.next;
        }
        if (index == 0)
            this.head = new Node(data, current);
        else
            current.next = new Node(data, current.next);
    }
    
    // Removes value of LinkedList at given index. If index is out of bounds, it removes the last value of LinkedList.
    public void remove(int index) {
        Node current = this.head;
        if (this.head == null)
            return;
        for (int i = 0; i < index-1; i++) {
            if (current.next == null)
                break;
            else if (current.next.next == null) {
                current.next = null;
                return;
            }
            else 
                current = current.next;
        }
        if (index == 0)
            this.head = current.next;
        else 
            current.next = current.next.next;
    }
    // Gets value of LinkedList at given index. If index is out of bounds, it gives the last value of LinkedList.
    public int get(int index) {
        Node current = this.head;
        if (this.head == null)
            return 0;
        for (int i = 0; i < index; i++) {
            if (current.next == null)
                break;
            else 
                current = current.next;
        }
        return current.data;
    }
    
    static class Node {
        public int data;
        public Node next;
        
        public Node() {}
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        
        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public static void main(String [] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(25);
        list.add(17, 1);
        list.print();
        list.remove(1);
        list.print();
        System.out.println("Index 1: "+list.get(1));
    }
}
