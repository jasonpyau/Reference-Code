import java.util.Arrays;
import java.util.Random;

class SelectionSort {
    public static void main(String[] args) {
        int arrayLength = 100;
        int [] nums = new int [arrayLength];
        
        generateRandom(nums);
        System.out.println("Unsorted: "+ Arrays.toString(nums)+"\n\n");
        selectionSort(nums);
        System.out.println("Sorted: "+ Arrays.toString(nums));
    }
    
    public static void selectionSort(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            int swapNum = nums[i], swapIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < swapNum) {
                    swapNum = nums[j];
                    swapIndex = j;
                }
            }
            nums[swapIndex] = nums[i];
            nums[i] = swapNum;
        }
    }
    
    public static void generateRandom(int [] nums) {
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt();
        }
    }
}
