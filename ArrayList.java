import java.lang.StringBuilder;

public class ArrayList<T> {
    private Object[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_SIZE = 10;
    
    public ArrayList() {
        this(DEFAULT_SIZE);
    }
    
    public ArrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.array = new Object[capacity];
    }
    
    public void add(T value) {
        add(size, value);
    }
    
    public void add(int index, T value) {
        if (size >= capacity) {
            expandList();
        }
        if (index < 0 || index > size) {
            printError();
            return;
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = value;
        this.size++;
    }
    
    public void addAll(T[] newArr) {
        addAll(size, newArr);
    }
    
    public void addAll(int index, T[] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            add(index+i, newArr[i]);
        }
    }
    
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < size)
            return (T)array[index];
        printError();
        return null;
    }
    
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            printError();
            return;
        }
            array[index] = value;
    }
    
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            printError();
            return null;
        }
        T removedItem = (T)array[index];
        if (index == capacity-1) {
            this.size--;
            return removedItem;
        }
        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i];
        }
        this.size--;
        return removedItem;
    }
    
    public void clear() {
        this.size = 0;
        this.capacity = DEFAULT_SIZE;
        Object[] newArr = new Object[DEFAULT_SIZE];
        this.array = newArr;
    }
    
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] arr) {
        for (int i = 0; i < size && i < arr.length; i++) {
            arr[i] = (T)array[i];
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) 
            sb.append(((array[i] == null) ? "null" : array[i].toString()) + ((i == size-1) ? "" : ", "));
        sb.append("]");
        return sb.toString();
    }
    
    public void print() {
        System.out.println(this);
    }
    
    public int size() {
        return this.size;
    }
    
    private void expandList() {
        capacity *= 2;
        Object[] newArr = new Object[capacity];
        for (int i = 0; i < size; i++)
            newArr[i] = array[i];
        this.array = newArr;
    }
    
    private void printError() {
        System.out.println("Error: Attempted to access out-of-bound index");
    }
    
    public static void main(String[] args) {
        System.out.println("Integer ArrayList:");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <= 100; i++)
            list1.add(i);
        list1.set(50, 200);
        list1.set(100, 300);
        System.out.println("Element at index 50: "+list1.get(50));
        System.out.println("Element at index 100: "+list1.get(100));
        System.out.println(list1);
        System.out.println("List size: "+list1.size());
        for(int i = list1.size()-2; i >= 0; i -= 2)
            list1.remove(i);
        System.out.println(list1);
        System.out.println("List size: "+list1.size());
        
        System.out.println("\nString ArrayList:");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Hello");
        list2.add("World!");
        System.out.println(list2);
        System.out.println("List size: "+list2.size());
        
        System.out.println("\n2D String ArrayList:");
        ArrayList<ArrayList<String>> list3 = new ArrayList<>();
        list3.add(list2);
        ArrayList<String> list4 = new ArrayList<>();
        String[] array4 = {"ArrayList", "by", "Jason", "Yau"};
        ArrayList<String> list5 = new ArrayList<>();
        list3.add(list4);
        list3.add(list5);
        list4.addAll(array4);
        list4.add(1, "implementation");
        System.out.println(list3);
        System.out.println("List size: "+list3.size());
        list1.clear();
        list2.clear();
        list3.clear();
        list4.clear();
        list5.clear();
        System.out.println(list3);
        System.out.println("List size: "+list3.size());
    }
}
