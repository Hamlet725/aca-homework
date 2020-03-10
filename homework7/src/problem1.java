import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input an integer: ");
        int digits = scanner.nextInt();
        sumDigits(digits);
        System.out.println("The sum is " + sumDigits(digits));
    }

    public static int sumDigits(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}
