public class Stack {
    private LinkedList list;
    
    public Stack() {
        list = new LinkedList();
    }
    
    public void push(int data) {
        list.add(data, 0);
    }
    
    public int pop() {
        return list.remove(0);
    }
    
    public int peek() {
        return list.get(0);
    }
    
    public boolean isEmpty() {
        return (list.size() == 0);
    }
    
    public void print() {
        System.out.println("---------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println("---------------------");
        }
        System.out.println(((list.size() == 0) ? "\n---------------------" : ""));
    }
    
    public static void main(String [] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.push(60);
        stack.push(100);
        stack.push(-25);
        stack.push(999);
        stack.push(2_000_000_000);
        stack.print();
        System.out.println("Peek: "+stack.peek());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Pop: "+stack.pop());
        System.out.println("Peek: "+stack.peek());
        stack.print();
        System.out.println("Pop: "+stack.pop());
        System.out.println("Pop: "+stack.pop());
        stack.print();
        System.out.println("Is empty: "+stack.isEmpty());
    }
    
    
    
    public class LinkedList {
        private Node head;
        private int size = 0;
        
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
            this.size++;
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
            this.size++;
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
        public int remove(int index) {
            Node current = this.head;
            int oldData;
            if (this.head == null) {
                printError();
                return 0;
            }
            this.size--;
            for (int i = 0; i < index-1; i++) {
                if (current.next == null)
                    break;
                else if (current.next.next == null) {
                    oldData = current.data;
                    current.next = null;
                    return oldData;
                }
                else 
                    current = current.next;
            }
            if (index == 0) {
                oldData = this.head.data;
                this.head = current.next;
            }
            else {
                oldData = current.next.data;
                current.next = current.next.next;
            }
            return oldData;
        }
        // Gets value of LinkedList at given index. If index is out of bounds, it gives the last value of LinkedList.
        public int get(int index) {
            Node current = this.head;
            if (this.head == null) {
                printError();
                return 0;
            }
            for (int i = 0; i < index; i++) {
                if (current.next == null)
                    break;
                else 
                    current = current.next;
            }
            return current.data;
        }
        
        public int size() {
            return this.size;
        }
        
        public void printError() {
        System.out.println("Error: Attempted to access out-of-bound index");
        }
        
        public class Node {
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
    }
}
