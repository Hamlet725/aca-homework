import java.util.Scanner;

public class problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number n:");
        int n = scanner.nextInt();
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                break;
            }
            i++;
        }
        if (n % i == 0) {
            System.out.println("Prime: " + n);
        } else if (n == 1) {
            System.out.println("Not prime: " + n);
        } else {
            System.out.println("not prime");
        }
    }
}
