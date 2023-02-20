public class LinkedList {
    Node head;
    
    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
    
    public void tailInsert(int data) {
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
    
    static class Node {
        public int data;
        public Node next;
        
        public Node() {}
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String [] args) {
        LinkedList list = new LinkedList();
        list.tailInsert(10);
        list.tailInsert(25);
        list.tailInsert(50);
        list.tailInsert(10);
        list.print();
    }

}
