import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        int a, b;
        if (args.length == 2) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input an positive integer for a. \n");
            System.out.print("a = ");
            a = scan.nextInt();
            System.out.println("Input an positive integer for b. \n");
            System.out.print("b = ");
            b = scan.nextInt();
        }
        
        if (a <= 0 || b <= 0) {
            System.out.println("Invalid Input.");
            return;
        }
        int gcd = gcd(a, b);
        System.out.println("\nThe GCD of "+a+" and "+b+" is "+gcd+".");
    }
    
    public static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) 
            return b;
        return gcd(b, r);
    }
}
