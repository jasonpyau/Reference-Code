public class ArrayList {
    private int [] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_SIZE = 16;
    
    public ArrayList() {
        this.size = 0;
        this.capacity = DEFAULT_SIZE;
        this.array = new int[capacity];
    }
    
    public void add(int value) {
        if (this.size >= capacity) {
            expandList();
        }
        this.array[this.size] = value;
        this.size++;
    }
    
    public int get(int index) {
        if (index >= 0 && index < this.size)
            return array[index];
        printError();
        return 0;
    }
    
    public void set(int index, int value) {
        if (index < 0 || index >= this.size) {
            printError();
            return;
        }
            this.array[index] = value;
    }
    
    public int remove(int index) {
        if (index < 0 || index >= this.size) {
            printError();
            return 0;
        }
        int removedItem = array[index];
        if (index == this.capacity-1) {
            this.size--;
            return removedItem;
        }
        for (int i = index+1; i < this.size; i++) {
            this.array[i-1] = array[i];
        }
        this.size--;
        return removedItem;
    }
    
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) 
            System.out.print(array[i] + ((i == size-1) ? "]\n" : ", "));
    }
    
    public int size() {
        return this.size;
    }
    
    private void expandList() {
        this.capacity *= 2;
        int [] newArr = new int[this.capacity];
        for (int i = 0; i < size; i++)
            newArr[i] = this.array[i];
        this.array = newArr;
    }
    
    private void printError() {
        System.out.println("Error: Attempted to access out-of-bound index");
    }
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= 100; i++)
            list.add(i);
        list.set(50, 200);
        list.set(100, 300);
        System.out.println("Element at index 50: "+list.get(50));
        System.out.println("Element at index 100: "+list.get(100));
        list.print();
        System.out.println("List size: "+list.size());
        for(int i = list.size()-2; i >= 0; i -= 2)
            list.remove(i);
        list.print();
        System.out.println("List size: "+list.size());
    }
}
