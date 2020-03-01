import java.util.Scanner;

public class problem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number n:");
        int n = scanner.nextInt();
        boolean isPrime = true;
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                isPrime = false;
                System.out.println("Not prime:");
                break;
            }
            i++;
        }
        if (isPrime) {
            System.out.println("Prime: " + n);

        }
    }
}
