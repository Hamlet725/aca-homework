import java.util.Scanner;

public class problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input n:");
        int n = scanner.nextInt();
        int i = 1, sum = 0;
        while (i < n) {
            System.out.print(i);
            if (i % 2 == 0) {
                System.out.print(" + ");
                sum -= i;
                i++;
            } else {
                System.out.print(" - ");
                sum += i;
                i++;
            }
        }
        if (i % 2 == 0) {
            System.out.println(n + " = " + (sum - n));
        } else {
            System.out.println(n + " = " + (n + sum));
        }
    }
}
