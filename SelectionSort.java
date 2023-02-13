import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input an integer, n, for the array length. \n");
        System.out.print("n = ");
        int arrayLength = scan.nextInt();
        int [] nums = new int [arrayLength];
        System.out.println("Input an integer, x, where all array values will be from [-x + 1, x - 1]. \n");
        System.out.print("x = ");
        int range = scan.nextInt();
        
        generateRandom(nums, range);
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
    
    public static void generateRandom(int [] nums, int range) {
        Random rd = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt()%range;
        }
    }
}
