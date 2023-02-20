import java.util.Scanner;
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
        if (args.length > 0) {
            for (String arg : args)
                list.add(Integer.parseInt(arg));
        }
        System.out.println("Input an integer:");
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Get item");
            System.out.println("4. Print LinkedList");
            System.out.println("5. Exit program");
            System.out.print("\nInput: ");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Input an value.");
                    System.out.print("\nInput: ");
                    int data = scan.nextInt();
                    System.out.println("Input an index, or -1 for end of LinkedList.");
                    System.out.print("\nInput: ");
                    int index = scan.nextInt();
                    if (index == -1)
                        list.add(data);
                    else 
                        list.add(data, index);
                    break;
                case 2:
                    System.out.println("Input an index.");
                    System.out.print("\nInput: ");
                    index = scan.nextInt();
                    list.remove(index);
                    break;
                case 3:
                    System.out.println("Input an index.");
                    System.out.print("\nInput: ");
                    index = scan.nextInt();
                    System.out.println("\n\nItem at index "+index+": "+list.get(index));
                    System.out.println("\nPress enter to continue.");
                    scan.nextLine();
                    scan.nextLine();
                    break;
                case 4:
                    System.out.println("\n");
                    list.print();
                    System.out.println("\nPress enter to continue.");
                    scan.nextLine();
                    scan.nextLine();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
