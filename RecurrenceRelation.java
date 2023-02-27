// g(1) = 2, g(2) = 2, g(3) = 3
// For all n > 3, g(n) = 3g(n-1) + g(n-2) + g(n-3).
// Print g(n) mod 10^9+7:
public class RecurrenceRelation {
    public static void main(String[] args) {
        g(1000);
    }
    
    public static void g(int n) {
        long [] nums = {2, 2, 3};
        for (int i = 0; i < nums.length && i < n; i++)
            System.out.println(nums[i]);
        for (int i = nums.length; i < n; i++) {
            long curr = (nums[0]+nums[1]+nums[2]*3)%(1_000_000_000+7);
            System.out.println(curr);
            for (int j = 0; j < nums.length-1; j++)
                nums[j] = nums[j+1];
            nums[2] = curr;
        }
    }
}
